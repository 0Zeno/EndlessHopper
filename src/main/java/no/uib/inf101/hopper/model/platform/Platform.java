package no.uib.inf101.hopper.model.platform;

public class Platform {
    private int x, y, width, height, platformNumber;
    private char platformSide;

    public Platform(int x, char platformSide, int y, int width, int height, int platformNumber) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.platformNumber = platformNumber;
        this.platformSide = getRandomPlatformSide();
    }

    private char getRandomPlatformSide() {
        char  tempPlatformSide = 'R';
        if (Math.random() > 0.5) {
            tempPlatformSide = 'L';
        }
        return tempPlatformSide;
    }

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

    public void movePlatformDown(int deltaY) {
        y += deltaY;
    }

    public void setY(int yPosition) {
        y = yPosition;
    }

    public void movePlatformToTop() {
        if (this.getPlatformY() > 798) {
            y = 0;
            this.setPlatformSide(getRandomPlatformSide());
        }
    }

    public int getPlatformY() {
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
