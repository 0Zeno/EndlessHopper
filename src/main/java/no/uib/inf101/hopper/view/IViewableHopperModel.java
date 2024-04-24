package no.uib.inf101.hopper.view;

import no.uib.inf101.hopper.model.GameState;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.model.platform.Platform;

import java.util.ArrayList;

public interface IViewableHopperModel {
    /**
     * @return gets the platforms from the hopper model
     */
    ArrayList<Platform> getPlatforms();

    /**
     * @return gets the hopping player box from the hopper model
     */
    HoppingPlayerBox getHoppingPlayerBox();

    char getPlatformColorChar(int index);

    /**
     * @return gets the current score
     */
    int getGameScore();

    /**
     * @return gets the highscore from hopper model
     */
    int getHighScore();

    /**
     * @return velocity of platforms and player
     */
    double getVelocity();

    /**
     * The gamestate can ble active, game over or game start
     * 
     * @return the gamstate of the game
     */
    GameState getGameState();

    /**
     * @return if debug mode is true or false
     */
    boolean isDebugMode();
}
