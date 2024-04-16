package no.uib.inf101.hopper.controller;

import no.uib.inf101.hopper.view.HopperView;

import java.awt.event.KeyEvent;

public class HopperController implements java.awt.event.KeyListener{

    private IControllableHopperModel controllableHopperModel;

    private HopperView hopperView;

    public HopperController(IControllableHopperModel controllableHopperModel, HopperView hopperView){
        this.controllableHopperModel = controllableHopperModel;
        this.hopperView = hopperView;
        this.hopperView.setFocusable(true);
        this.hopperView.addKeyListener(this);
    }



    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == (KeyEvent.VK_LEFT)){
            controllableHopperModel.movePlayer('L');
            hopperView.repaint();
        } else if (e.getKeyCode() == (KeyEvent.VK_RIGHT)){
            controllableHopperModel.movePlayer('R');
            hopperView.repaint();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}
