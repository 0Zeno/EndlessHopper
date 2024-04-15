package no.uib.inf101.hopper.model;

import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.view.IViewableHopperModel;

import java.util.ArrayList;

public class HopperModel implements IViewableHopperModel {

    ArrayList<Platform> platforms;
    public HopperModel( ){
        this.platforms = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            this.platforms.add(new Platform(150, 'L', 600 - i * 100, 125,
                    25, i));
        }
    }

    @Override
    public ArrayList<Platform> getPlatforms() {
        return platforms;
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
