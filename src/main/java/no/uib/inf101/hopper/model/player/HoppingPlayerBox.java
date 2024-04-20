package no.uib.inf101.hopper.model.player;

public class HoppingPlayerBox {
    int x, y, width, height, currentPlatformNum;
    char side;

    public HoppingPlayerBox(int x, int y, int width, int height, char side, int currentPlatform) {
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

    public int getPlayerY() {
        return y;
    }

    public char getSide() {
        return side;
    }

    public int getCurrentPlatformNum() {
        return currentPlatformNum;
    }

    private void playerHop() {
        y -= 100;
        if (currentPlatformNum < 7) {
            currentPlatformNum++;
        } else {
            currentPlatformNum = 0;
        }
    }

    public void setPlayerY(int deltaY) {
        y += deltaY;
    }

    public HoppingPlayerBox playerHopToRight() {
        System.out.println("move to the right");
        playerHop();
        x = 350;
        side = 'R';
        return new HoppingPlayerBox(x, y, width, height, side, currentPlatformNum);
    }

    public HoppingPlayerBox playerHopToLeft() {
        System.out.println("move to the left");
        playerHop();
        x = 195;
        side = 'L';
        return new HoppingPlayerBox(x, y, width, height, side, currentPlatformNum);
    }


}
