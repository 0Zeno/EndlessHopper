package no.uib.inf101.hopper.model.platform;

public class Platform {
    private final int x, width, height, platformNumber;

    private double y;
    private char platformSide, platformColor;

    public Platform(int x, char platformSide, int y, int width, int height, int platformNumber, char color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.platformNumber = platformNumber;
        this.platformSide = randomPlatformSideGenerator();
        this.platformColor = getRandomColorChar();
    }

    public char getPlatformColor() {
        return platformColor;
    }

    public char getPlatformSide() {
        return platformSide;
    }

    public void setPlatformSide(char sideToSet) {
        platformSide = sideToSet;
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

    public int getPlatformX() {
        if (platformSide == 'R') {
            return x * 2;
        }
        return x;
    }

    private char randomPlatformSideGenerator() {
        char tempPlatformSide = 'R';
        if (Math.random() > 0.5) {
            tempPlatformSide = 'L';
        }
        return tempPlatformSide;
    }

    private char getRandomColorChar() {
        String colorOptions = "RFGYDL";
        int index = (int) (Math.random() * colorOptions.length());
        return colorOptions.charAt(index);
    }

    public void movePlatformDown(double deltaY) {
        y += deltaY;
    }

    public void movePlatformToTop() {
        if (this.getPlatformY() > 798) {
            y = 0;
            this.setPlatformSide(randomPlatformSideGenerator());
            this.platformColor = getRandomColorChar();
        }
    }
}