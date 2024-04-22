package no.uib.inf101.hopper.view;

import java.awt.*;

public interface IColorTheme {

    /**
     * @return the hopping player box color
     */
    Color getHopperPlayerColor();

    /**
     * @return the background color
     */
    Color getBackgroundColor();

    /**
     * @return the game over coloer
     */
    Color getGameOverColor();

    /**
     * @param c character representing a color in color theme
     * @return the color represented by c
     */
    Color getPlatformColor(Character c);

}
