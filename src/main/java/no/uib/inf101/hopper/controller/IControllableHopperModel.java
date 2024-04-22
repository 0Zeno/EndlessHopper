package no.uib.inf101.hopper.controller;

import no.uib.inf101.hopper.model.GameState;

public interface IControllableHopperModel {

    /**
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
     * Resets the platforms, score and hopper
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


}