package no.uib.inf101.hopper.view;

import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.model.platform.Platform;

import java.util.ArrayList;

public interface IViewableHopperModel {
    ArrayList<Platform> getPlatforms();

    HoppingPlayerBox getHoppingPlayerBox();

    int getGameScore();

    double getVelocity();
}
