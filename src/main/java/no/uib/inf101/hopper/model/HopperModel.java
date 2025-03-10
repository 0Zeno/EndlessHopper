package no.uib.inf101.hopper.model;

import java.util.ArrayList;

import no.uib.inf101.hopper.controller.IControllableHopperModel;
import no.uib.inf101.hopper.model.platform.Platform;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.view.IViewableHopperModel;

public class HopperModel implements IViewableHopperModel, IControllableHopperModel {
    private GameState currentGameState;
    private int anchorPointPlatform;
    private HoppingPlayerBox playerBox;
    private int gameScore = 0;
    private int highScore = 0;
    private double velocity;
    private boolean isDebugMode;

    ArrayList<Platform> platforms;

    public HopperModel() {
        this.anchorPointPlatform = 600;
        resetGame(8);
        this.currentGameState = GameState.GAME_START;
        this.isDebugMode = false;
    }

    @Override
    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    @Override
    public HoppingPlayerBox getHoppingPlayerBox() {
        return playerBox;
    }

    @Override
    public char getPlatformColorChar(int index) {
        return platforms.get(index).getPlatformColor();
    }

    @Override
    public GameState getGameState() {
        return currentGameState;
    }

    @Override
    public int getGameScore() {
        return gameScore;
    }

    protected void setGameScore(int gameScoreToSetTo) {
        gameScore = gameScoreToSetTo;
    }

    @Override
    public int getHighScore() {
        if (gameScore > highScore) {
            highScore = gameScore;
        }
        return highScore;
    }

    @Override
    public int getTimerDelay() {
        return 10;
    }

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public boolean isDebugMode() {
        return isDebugMode;
    }

    @Override
    public void switchDebugMode() {
        isDebugMode = !isDebugMode;
    }

    @Override
    public void movePlayer(char side) {
        if (side == 'L' && isLeagleHop(side, playerBox, platforms)) {
            playerBox = playerBox.playerHopToLeft(platforms.get(getNextPlatformNumber()).getPlatformY() - 40);
            gameScore++;
            increaseVelocity();
        } else if (side == 'R' && isLeagleHop(side, playerBox, platforms)) {
            playerBox = playerBox.playerHopToRight(platforms.get(getNextPlatformNumber()).getPlatformY() - 40);
            gameScore++;
            increaseVelocity();
        } else {
            currentGameState = GameState.GAME_OVER;
        }
    }

    /**
     * increases the velocity of the player and platform based on player position
     */
    protected void increaseVelocity() {
        if (getGameScore() % 11 == 0 && getGameScore() > 10 && velocity < 10) {
            velocity += 0.2;
        }
        if (getHoppingPlayerBox().getPlayerY() < 75) {
            velocity += 0.05;
        }
        if (getHoppingPlayerBox().getPlayerY() < 50) {
            velocity += 0.075;
        }
        if (getHoppingPlayerBox().getPlayerY() < 25) {
            velocity += 0.1;
        }
    }

    /**
     * Checks if the player is under the screen. If the player is then the game is
     * over
     */
    protected void checkIfPlayerUnderScreen() {
        if (playerBox.getPlayerY() > 700) {
            currentGameState = GameState.GAME_OVER;
        }
    }

    @Override
    public void resetGame(int amountOfPlatforms) {
        this.platforms = new ArrayList<>();
        this.velocity = 2.0;
        this.gameScore = 0;
        for (int i = 0; i < amountOfPlatforms; i++) {
            this.platforms.add(new Platform(150, 'L', anchorPointPlatform - i * 100, 125,
                    25, i, 'R'));
        }
        this.playerBox = new HoppingPlayerBox(platforms.get(0).getPlatformX() + 50,
                platforms.get(0).getPlatformY() - 40, 40, 40, platforms.get(0).getPlatformSide(), 0);
        currentGameState = GameState.GAME_ACTIVE;
    }

    @Override
    public void clockTick() {
        for (Platform p : platforms) {
            p.movePlatformDown(velocity);
            p.movePlatformToTop();
        }
        playerBox.setPlayerY(velocity);
        checkIfPlayerUnderScreen();
    }

    /**
     * Method to check if a jump the player wants to do is allowed
     * 
     * @param sideToJump the side the player box wants to jump to
     * @param hopper     the player box
     * @param platforms  the list of platforms
     * @return ture if the hop is allowed
     */
    protected boolean isLeagleHop(char sideToJump, HoppingPlayerBox hopper,
            ArrayList<Platform> platforms) {
        char nextPlatformSide = getNextPlatform(hopper, platforms).getPlatformSide();
        return (nextPlatformSide == sideToJump);
    }

    /**
     * The method is used to get the next current platform number
     * 
     * @return the next platform number after the player jumps
     */
    private int getNextPlatformNumber() {
        if (playerBox.getCurrentPlatformNum() < 7) {
            return playerBox.getCurrentPlatformNum() + 1;
        } else {
            return 0;
        }
    }

    /**
     * gets the nest platform that the player can jump to
     * 
     * @param hopper    the player box
     * @param platforms a list of platforms
     * @return returns the next platform that the player can jump to
     */
    protected Platform getNextPlatform(HoppingPlayerBox hopper, ArrayList<Platform> platforms) {
        int nextPlatform = hopper.getCurrentPlatformNum() + 1;
        if (nextPlatform < 8) {
            return platforms.get(nextPlatform);
        } else {
            return platforms.get(0);
        }
    }
}