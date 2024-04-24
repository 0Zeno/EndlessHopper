package no.uib.inf101.hopper.view;

import java.awt.*;

public class ColorTheme implements IColorTheme {

    @Override
    public Color getHopperPlayerColor() {
        return new Color(1, 150, 50);
    }

    @Override
    public Color getBackgroundColor() {
        return new Color(0, 0, 0);
    }

    @Override
    public Color getGameOverColor() {
        return (new Color(255, 255, 255, 10));
    }

    @Override
    public Color getPlatformColor(Character c) {
        Color color = switch (c) {
            case 'R' -> new Color(93, 43, 125);
            case 'F' -> new Color(167, 45, 137);
            case 'G' -> new Color(20, 116, 187);
            case 'Y' -> new Color(143, 195, 62);
            case 'D' -> new Color(254, 238, 34);
            case 'L' -> new Color(228, 30, 38);
            default -> throw new IllegalArgumentException("No avalible color for '" + c + "'");
        };
        return color;
    }
}
