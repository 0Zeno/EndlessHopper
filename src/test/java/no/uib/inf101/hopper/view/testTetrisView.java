package no.uib.inf101.hopper.view;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class testTetrisView {
    @Test
    public void sanityDefaultColorThemeTest() {
    ColorTheme colors = new ColorTheme();
    assertEquals(new Color(0, 0, 0), colors.getBackgroundColor());
    assertEquals(new Color(255, 255, 255, 10), colors.getGameOverColor());
    assertEquals(new Color(228, 30, 38), colors.getPlatformColor('L'));
    assertThrows(IllegalArgumentException.class, () -> colors.getPlatformColor('\n'));
}}
