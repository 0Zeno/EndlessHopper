package no.uib.inf101.hopper.model.player;

public class HoppingPlayerBox {
    int x, y, width, height, currentPlatform;
    char side;

    public HoppingPlayerBox(int x, int y, int width, int height, char side, int currentPlatform){
        this.side = side;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.currentPlatform = currentPlatform;

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public int getPlayerX(){
        return x;
    }

    public int getPlayerY(){
        return y;
    }

    public char getSide() {
        return side;
    }

    public int getCurrentPlatform() {
        return currentPlatform;
    }

    private void playerHop(){
        y -= 100;
        if (currentPlatform < 8){
            currentPlatform ++;
        } else {
            currentPlatform = 0;
        }
    }

   public HoppingPlayerBox playerHopToRight(){
       System.out.println("move to the right");
       playerHop();
       x = 350;
       side = 'R';
       return new HoppingPlayerBox(x, y, width, height, side, currentPlatform);
   };

    public HoppingPlayerBox playerHopToLeft(){
        System.out.println("move to the left");
        playerHop();
        x = 195;
        side = 'L';
        return new HoppingPlayerBox(x, y, width, height, side, currentPlatform);
    };

    /**
     *
     * x and y coordinates ferdig
     * legal move
     * next legal move
     * get side
     * place on platform 0 on start
     */

}
