package no.uib.inf101.hopper.view;

import java.awt.*;

public interface IColorTheme {

    Color getHopperPlayerColor();

    Color getBackgroundColor();

    Color getGameOverColor();

    Color getCellColor(Character c);

}
