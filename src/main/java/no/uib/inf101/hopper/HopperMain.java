package no.uib.inf101.hopper;

import javax.swing.*;

import no.uib.inf101.hopper.controller.HopperController;
import no.uib.inf101.hopper.model.GameState;
import no.uib.inf101.hopper.model.HopperModel;
import no.uib.inf101.hopper.view.HopperView;

public class HopperMain {
    public static final String WINDOW_TITLE = "Endless Hopper";

    public static void main(String[] args) {
        HopperModel model = new HopperModel();
        HopperView view = new HopperView(model);
        new HopperController(model, view);

        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // works also with true but doesn't look good
        frame.setContentPane(view);

        // Here we set which component to view in our window
        frame.setLocationRelativeTo(null);

        // Call these methods to actually display the window
        frame.pack();

        // places frame in middle
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
