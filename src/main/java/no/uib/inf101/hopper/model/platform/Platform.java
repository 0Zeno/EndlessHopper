package no.uib.inf101.hopper.model.platform;

import java.awt.*;

public class Platform {
    private int x, width, height, platformNumber;

    private double y;
    private char platformSide, color;

    public Platform(int x, char platformSide, int y, int width, int height, int platformNumber, char color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.platformNumber = platformNumber;
        this.platformSide = getRandomPlatformSide();
        this.color = color;
    }

    private char getRandomPlatformSide() {
        char  tempPlatformSide = 'R';
        if (Math.random() > 0.5) {
            tempPlatformSide = 'L';
        }
        return tempPlatformSide;
    }

    public char getColor() {return color;}
    public char getPlatformSide() {
        return platformSide;
    }

    public void setPlatformSide(char sideToSet) {
        platformSide = sideToSet;
    }

    public int getPlatformX() {
        if (platformSide == 'R') {
            return x * 2;
        }
        return x;
    }

    public void movePlatformDown(double deltaY) {
        y += deltaY;
    }
    public void movePlatformToTop() {
        if (this.getPlatformY() > 798) {
            y = 0;
            this.setPlatformSide(getRandomPlatformSide());
        }
    }
    public double getPlatformY() {
        return y;
    }
    public int getPlatformWidth() {
        return width;
    }
    public int getPlatformHeight() {
        return height;
    }
    public int getPlatformNumber() {
        return platformNumber;
    }
}
