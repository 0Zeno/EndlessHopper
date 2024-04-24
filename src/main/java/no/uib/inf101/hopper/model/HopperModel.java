package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.controller.IControllableHopperModel;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.view.IViewableHopperModel;

import java.util.ArrayList;

public class HopperModel implements IViewableHopperModel, IControllableHopperModel {
    private GameState currentGameState;
    private int anchorPointPlatform;
    private HoppingPlayerBox playerBox;
    int gameScore = 0;
    int highScore = 0;
    double velocity;
    boolean isDebugMode;

    ArrayList<Platform> platforms;

    public HopperModel() {
        this.anchorPointPlatform = 600;
        resetGame(8);
        this.currentGameState = GameState.GAME_START;
        this.isDebugMode = false;
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
    public char getPlatformColorChar(int index) {
        return platforms.get(index).getPlatformColor();
    }

    @Override
    public void movePlayer(char side) {
        if (side == 'L' && isLeagleHop(side, playerBox, platforms)) {
            playerBox = playerBox.playerHopToLeft(platforms.get(getNextPlatformNumber()).getPlatformY() - 40);
            gameScore++;
            increaseVelocity();
        } else if (side == 'R' && isLeagleHop(side, playerBox, platforms)) {
            playerBox = playerBox.playerHopToRight(platforms.get(getNextPlatformNumber()).getPlatformY() - 40);
            gameScore++;
            increaseVelocity();
        } else {
            currentGameState = GameState.GAME_OVER;
        }
    }

    private void increaseVelocity() {
        if (getGameScore() % 11 == 0 && getGameScore() > 10 && velocity < 10) {
            velocity += 0.2;
        }
        if (getHoppingPlayerBox().getPlayerY() < 75) {
            velocity += 0.05;
        }
        if (getHoppingPlayerBox().getPlayerY() < 50) {
            velocity += 0.075;
        }
    }

    protected void checkIfPlayerUnderScreen() {
        if (playerBox.getPlayerY() > 700) {
            currentGameState = GameState.GAME_OVER;
        }
    }

    private int getNextPlatformNumber() {
        if (playerBox.getCurrentPlatformNum() < 7) {
            return playerBox.getCurrentPlatformNum() + 1;
        } else {
            return 0;
        }
    }

    @Override
    public GameState getGameState() {
        return currentGameState;
    }

    public void resetGame(int amountOfPlatforms) {
        this.platforms = new ArrayList<>();
        this.velocity = 3.0;
        this.gameScore = 0;
        for (int i = 0; i < amountOfPlatforms; i++) {
            this.platforms.add(new Platform(150, 'L', anchorPointPlatform - i * 100, 125,
                    25, i, 'R'));
        }
        this.playerBox = new HoppingPlayerBox(platforms.get(0).getPlatformX() + 50,
                platforms.get(0).getPlatformY() - 40, 40, 40, platforms.get(0).getPlatformSide(), 0);
        currentGameState = GameState.GAME_ACTIVE;
    }

    @Override
    public int getGameScore() {
        return gameScore;
    }

    @Override
    public int getHighScore() {
        if (gameScore > highScore) {
            highScore = gameScore;
        }
        return highScore;
    }

    @Override
    public int getTimerDelay() {
        return 1;
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public void clockTick() {
        for (Platform p : platforms) {
            p.movePlatformDown(velocity);
            p.movePlatformToTop();
        }
        playerBox.setPlayerY(velocity);
        checkIfPlayerUnderScreen();
    }

    @Override
    public boolean isDebugMode() {
        return isDebugMode;
    }

    @Override
    public void switchDebugMode() {
        isDebugMode = !isDebugMode;
    }

    protected boolean isLeagleHop(char sideToJump, HoppingPlayerBox hopper,
            ArrayList<Platform> platforms) {
        char nextPlatformSide = getNextPlatform(hopper, platforms).getPlatformSide();
        return (nextPlatformSide == sideToJump);
    }

    protected Platform getNextPlatform(HoppingPlayerBox hopper, ArrayList<Platform> platforms) {
        int nextPlatform = hopper.getCurrentPlatformNum() + 1;
        if (nextPlatform < 8) {
            return platforms.get(nextPlatform);
        } else {
            return platforms.get(0);
        }
    }
}