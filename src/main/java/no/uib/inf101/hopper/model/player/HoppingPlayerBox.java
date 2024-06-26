package no.uib.inf101.hopper.model.player;

public class HoppingPlayerBox {
    private int x, width, height, currentPlatformNum;
    private double y;
    private char side;

    public HoppingPlayerBox(int x, double y, int width, int height, char side, int currentPlatform) {
        this.side = side;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.currentPlatformNum = currentPlatform;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPlayerX() {
        return x;
    }

    public double getPlayerY() {
        return y;
    }

    public char getSide() {
        return side;
    }

    public int getCurrentPlatformNum() {
        return currentPlatformNum;
    }

    public void setPlayerY(double deltaY) {
        y += deltaY;
    }


    /**
     * Used to set new y coordinate for player
     * and to increase the players current platform number
     * @param newY the y coordinate where the player is placed
     */
    private void playerHop(double newY) {
        y = newY;
        if (currentPlatformNum < 7) {
            currentPlatformNum++;
        } else {
            currentPlatformNum = 0;
        }
    }

    /**
     * Makes the player jump to the right
     * @param nextPlatformY the y coordinate of the next platform
     * @return new hopping player box with new x and y coordinates and platform number
     */
    public HoppingPlayerBox playerHopToRight(double nextPlatformY) {
        System.out.println("move to the right");
        playerHop(nextPlatformY);
        x = 345;
        side = 'R';
        return new HoppingPlayerBox(x, y, width, height, side, currentPlatformNum);
    }

    /**
     * Makes the player jump to the left
     * @param nextPlatformY the y coordinate of the next platform
     * @return new hopping player box with new x and y coordinates and platform number
     */
    public HoppingPlayerBox playerHopToLeft(double nextPlatformY) {
        System.out.println("move to the left");
        playerHop(nextPlatformY);
        x = 195;
        side = 'L';
        return new HoppingPlayerBox(x, y, width, height, side, currentPlatformNum);
    }

}
