package no.uib.inf101.hopper.controller;

import no.uib.inf101.hopper.model.GameState;
import no.uib.inf101.hopper.view.HopperView;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;


public class HopperController implements java.awt.event.KeyListener {
    private Timer timer;
    private IControllableHopperModel controllableHopperModel;
    private HopperView hopperView;


    public HopperController(IControllableHopperModel controllableHopperModel, HopperView hopperView) {
        this.controllableHopperModel = controllableHopperModel;
        this.hopperView = hopperView;
        this.hopperView.setFocusable(true);
        this.hopperView.addKeyListener(this);
        this.timer = new Timer(controllableHopperModel.getTimerDelay(), this::clockTick);
        timer.start();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D){
            controllableHopperModel.switchDebugMode();
        }

        if ((controllableHopperModel.getGameState() == GameState.GAME_OVER )||
        (controllableHopperModel.getGameState() == GameState.GAME_START) &&
        (e.getKeyCode() == KeyEvent.VK_ENTER)){
            controllableHopperModel.resetGame(8);
        }

        if (controllableHopperModel.getGameState() == GameState.GAME_ACTIVE) {
            if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
                controllableHopperModel.movePlayer('L');
                hopperView.repaint();
            } else if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
                controllableHopperModel.movePlayer('R');
                hopperView.repaint();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Handles the clock tick event.
     * If the game state is active, it calls the clockTick method of the
     * controllableTetrisModel,
     * delays for a certain period of time, and then repaints the tetrisView.
     * Starts and stops the music
     *
     * @param actionEvent the action event triggering the clock tick
     */
    private void clockTick(ActionEvent actionEvent) {
        if (controllableHopperModel.getGameState() == GameState.GAME_ACTIVE) {
            controllableHopperModel.clockTick();
            delay();
            hopperView.repaint();
        }
    }
    private void delay() {
        int delay = controllableHopperModel.getTimerDelay();
        timer.setDelay(delay);
        timer.setInitialDelay(delay);
    }
}