package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.controller.IControllableHopperModel;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.view.IViewableHopperModel;

import java.util.ArrayList;

public class HopperModel implements IViewableHopperModel, IControllableHopperModel {

    HoppingPlayerBox playerBox;
    ArrayList<Platform> platforms;
    public HopperModel(int amountOfPlatforms){
        this.platforms = new ArrayList<>();
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
        if (side == 'L') {
            playerBox = playerBox.playerHopToLeft();
        } else if (side == 'R') {
            playerBox = playerBox.playerHopToRight();
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
