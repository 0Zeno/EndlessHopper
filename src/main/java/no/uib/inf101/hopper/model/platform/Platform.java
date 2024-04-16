package no.uib.inf101.hopper.model.platform;

public class Platform {
    private int x, y, width, height, platformNumber;
    private char platformSide;
    public Platform(int x, char platformSide, int y, int width, int height, int platformNumber){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.platformNumber = platformNumber;
        this.platformSide = getRandomPlatformSide(this.platformSide);
    }

    private char getRandomPlatformSide(char platformSide){
        platformSide = 'R';
        if (Math.random() > 0.5){
            platformSide = 'L';
        }
        return platformSide;
    }

    public char getPlatformSide(){
        return platformSide;
    }

    public int getPlatformX() {
        if (platformSide == 'R'){
            return  x * 2;
        }
        return x;
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

    public int getPlatformNumber(){
        return platformNumber;
    }


}
