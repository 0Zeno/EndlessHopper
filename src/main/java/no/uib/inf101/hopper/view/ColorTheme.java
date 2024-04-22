package no.uib.inf101.hopper.view;

import java.awt.*;

public class ColorTheme implements IColorTheme {


    @Override
    public Color getHopperPlayerColor() {
        return new Color(0, 255, 0  );
    }

    @Override
    public Color getBackgroundColor() {
        return new Color(0, 0, 0);
    }

    @Override
    public Color getGameOverColor() {
        return (new Color(255, 255, 255, 10));
    }

    public Color getRandomColor() {
        String colorOptions = "RGBYOPM";
        int index = (int) (Math.random() * colorOptions.length());
        Character colorChar = colorOptions.charAt(index);
        return getCellColor(colorChar);
    }

    @Override
    public Color getCellColor(Character c) {
        Color color = switch (c) {
            case 'R' -> Color.RED;
            case 'G' -> Color.GREEN;
            case 'B' -> Color.BLUE;
            case 'Y' -> Color.GRAY;
            case 'O' -> Color.ORANGE;
            case 'P' -> Color.PINK;
            case 'M' -> Color.MAGENTA;
            default -> throw new IllegalArgumentException("No avalible color for '" + c + "'");
        };
        return color;
    }
}
