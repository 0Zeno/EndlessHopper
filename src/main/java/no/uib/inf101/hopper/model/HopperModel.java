package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.controller.IControllableHopperModel;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.view.IViewableHopperModel;

import java.util.ArrayList;

public class HopperModel implements IViewableHopperModel, IControllableHopperModel {

    private GameState currentGameState;
    HoppingPlayerBox playerBox;
    ArrayList<Platform> platforms;
    public HopperModel(int amountOfPlatforms){
        this.platforms = new ArrayList<>();
        this.currentGameState = GameState.GAME_ACTIVE;
        for (int i = 0; i < amountOfPlatforms; i++) {
            this.platforms.add(new Platform(150, 'L', 600 - i * 100, 125,
                    25, i));
        }
        this.playerBox = new HoppingPlayerBox( 195, 560, 40, 40, 'L', 0);

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
        } else if (side == 'R' && isLeagleHop(side, playerBox, platforms)) {
            playerBox = playerBox.playerHopToRight();
        }
        else{
            currentGameState = GameState.GAME_OVER;
        }
    }

    private boolean isLeagleHop(char sideToJump, HoppingPlayerBox hopper, ArrayList<Platform> platforms){
        char nextPlatformSide = getNextPlatform(hopper, platforms).getPlatformSide();
        return (nextPlatformSide == sideToJump);
    }

    private Platform getNextPlatform(HoppingPlayerBox hopper, ArrayList<Platform> platforms){
        int currentPlatform = hopper.getCurrentPlatformNum() + 1;
        if (currentPlatform < 8){
            return platforms.get(currentPlatform);
        } else {
            return platforms.get(0);

        }

    }


    /**
     * move platform to top
     * glue platforms
     * getTimerDelay
     * clockTick
     * Reset game
     * test if l as char on platform makes x-coordinate to left and same with right...
     * test if rekkefølge is correct
     * test if distance is correct
     */
}
