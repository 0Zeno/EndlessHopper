package no.uib.inf101.hopper;

import javax.swing.*;

import no.uib.inf101.hopper.model.HopperModel;
import no.uib.inf101.hopper.view.HopperView;


public class HopperMain {
  public static final String WINDOW_TITLE = "Endless Hopper";
  public static void main(String[] args) {
    HopperModel model = new HopperModel();
    HopperView view = new HopperView(model);


    JFrame frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);

    frame.setContentPane(view);

    // Here we set which component to view in our window
    frame.setLocationRelativeTo(null);

    // Call these methods to actually display the window
    frame.pack();
    
    //setter rammen i midten
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
}
