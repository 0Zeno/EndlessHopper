package no.uib.inf101.hopper.controller;

import no.uib.inf101.hopper.model.GameState;

public interface IControllableHopperModel {

    /**
     * moves the player to a side L or R, increases the score and the velocity using
     * the increaseVelocity function
     * 
     * @param side the side the hopper wants to move
     */
    void movePlayer(char side);

    /**
     *
     * @return the game state of the game
     */
    GameState getGameState();

    /**
     * Resets the platforms, score velocity, and hopper.
     * 
     * @param amountOfPlatforms the amount of platforms
     */
    void resetGame(int amountOfPlatforms);

    /**
     *
     * @return the delay for the timer
     */
    int getTimerDelay();

    /**
     * Advances the game by one clock tick.
     */
    void clockTick();

    /**
     * Switches from and to debug mode if "d" key is pressed
     */
    void switchDebugMode();
}