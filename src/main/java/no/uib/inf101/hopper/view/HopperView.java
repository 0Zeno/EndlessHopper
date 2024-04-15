package no.uib.inf101.hopper.view;

import no.uib.inf101.hopper.model.platform.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class HopperView extends JPanel {
        private final ColorTheme colorTheme;
        private IViewableHopperModel viewableHopperModel;


        private static final double OUTERMARGIN = 10;

        public HopperView(IViewableHopperModel viewableHopperModel) {
                this.setFocusable(true);
                this.setPreferredSize(new Dimension(600, 700));
                this.colorTheme = new ColorTheme();
                this.viewableHopperModel = viewableHopperModel;
                Color bg = colorTheme.getBackgroundColor();
                this.setBackground(bg);

        }

        private void drawGame(Graphics2D g2) {
                double gameWidth = getWidth();
                double gameHeight = getHeight();
                Rectangle2D background = new Rectangle2D.Double(OUTERMARGIN, OUTERMARGIN,
                        gameWidth - 2 * OUTERMARGIN,
                        gameHeight - 2 * OUTERMARGIN);
                g2.setColor(colorTheme.getBackgroundColor());
                g2.fill(background);



                for (Platform p : viewableHopperModel.getPlatforms()) {
                        int platformX = p.getPlatformX();
                        Rectangle2D platform = new Rectangle2D.Double(platformX,
                                p.getPlatformY(), p.getPlatformWidth(),  p.getPlatformHeight());
                        g2.setColor(colorTheme.getRandomColor());
                        g2.fill(platform);
                        g2.draw(platform);
                        String platformNumber = String.valueOf(p.getPlatformNumber());
                        String platformSide = String.valueOf(p.getPlatformSide());
                        g2.setColor(Color.BLACK);
                        g2.drawString(platformNumber + platformSide, platformX + 10, p.getPlatformY() + 10);


                }
        }

        public void magiskMetode(int i){

        }

        @Override
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                drawGame(g2);
        }

}
