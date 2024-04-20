package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.controller.IControllableHopperModel;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.view.HopperView;
import no.uib.inf101.hopper.view.IViewableHopperModel;

import java.util.ArrayList;

public class HopperModel implements IViewableHopperModel, IControllableHopperModel {
    private GameState currentGameState;
    private int anchorPointPlatform;
    private HoppingPlayerBox playerBox;
    int gameScore = 0;

    ArrayList<Platform> platforms;

    public HopperModel(int amountOfPlatforms) {
        this.anchorPointPlatform = 600;
        this.platforms = new ArrayList<>();
        this.currentGameState = GameState.GAME_ACTIVE;
        for (int i = 0; i < amountOfPlatforms; i++) {
            this.platforms.add(new Platform(150, 'L', anchorPointPlatform - i * 100, 125,
                    25, i));
        }
        this.playerBox = new HoppingPlayerBox(platforms.get(0).getPlatformX() + 50,
                560, 40, 40, platforms.get(0).getPlatformSide(), 0);
    }

    @Override
    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    @Override
    public HoppingPlayerBox getHoppingPlayerBox() {
        return playerBox;
    }

    @Override
    public void movePlayer(char side) {
        if (side == 'L' && isLeagleHop(side, playerBox, platforms)) {
            playerBox = playerBox.playerHopToLeft();
            gameScore++;
        } else if (side == 'R' && isLeagleHop(side, playerBox, platforms)) {
            playerBox = playerBox.playerHopToRight();
            gameScore++;
        } else {
            currentGameState = GameState.GAME_OVER;
        }
    }

    @Override
    public GameState getGameState() {
        return currentGameState;
    }

    @Override
    public void resetGame() {
        currentGameState = GameState.GAME_ACTIVE;
    }

    @Override
    public int getGameScore() {
        return gameScore;
    }

    @Override
    public int getTimerDelay() {
        return 1;
    }

    @Override
    public void clockTick() {
        int velocity = 2;
        for (Platform p : platforms) {
            p.movePlatformDown(velocity);
            p.movePlatformToTop();
        }
        playerBox.setPlayerY(velocity);
    }

    private boolean isLeagleHop(char sideToJump, HoppingPlayerBox hopper,
                                ArrayList<Platform> platforms) {
        char nextPlatformSide = getNextPlatform(hopper, platforms).getPlatformSide();
        return (nextPlatformSide == sideToJump);
    }

    private Platform getNextPlatform(HoppingPlayerBox hopper, ArrayList<Platform> platforms) {
        int currentPlatform = hopper.getCurrentPlatformNum() + 1;
        if (currentPlatform < 8) {
            return platforms.get(currentPlatform);
        } else {
            return platforms.get(0);
        }
    }
}