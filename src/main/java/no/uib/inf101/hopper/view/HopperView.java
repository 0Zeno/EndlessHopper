package no.uib.inf101.hopper.view;

import no.uib.inf101.hopper.model.GameState;
import no.uib.inf101.hopper.model.player.HoppingPlayerBox;
import no.uib.inf101.hopper.model.platform.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

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
        if (viewableHopperModel.getGameState() == GameState.GAME_ACTIVE){
            g2.fill(background);
            drawPlatforms(g2);
            drawPlayer(g2);
            drawGameScore(g2);
        } else if (viewableHopperModel.getGameState() == GameState.GAME_OVER){
            drawGameOver(g2);
        } else if (viewableHopperModel.getGameState() == GameState.GAME_START){
            drawGameStart(g2);
        }
    }
    private void drawPlatforms(Graphics2D g2) {
        for (Platform p : viewableHopperModel.getPlatforms()) {
            int platformX = p.getPlatformX();
            Rectangle2D platform = new Rectangle2D.Double(platformX,
                    p.getPlatformY(), p.getPlatformWidth(), p.getPlatformHeight());
            g2.setColor(colorTheme.getPlatformColor(viewableHopperModel.getPlatformColorChar(p.getPlatformNumber())));
            g2.fill(platform);
            g2.draw(platform);
            if (viewableHopperModel.isDebugMode()){
                String platformNumber = String.valueOf(p.getPlatformNumber());
                String platformSide = String.valueOf(p.getPlatformSide());
                g2.setColor(Color.BLACK);
                g2.drawString(platformNumber + platformSide, platformX + 10, (int) (p.getPlatformY() + 10));
            }

        }
    }

    private void drawGameScore(Graphics2D g2) {
        String gameScore = String.valueOf(viewableHopperModel.getGameScore());
        String gameVelocity = String.valueOf(viewableHopperModel.getVelocity());
        g2.setColor(Color.WHITE);
        if (viewableHopperModel.isDebugMode()) {
            g2.drawString("Current velocity: " + gameVelocity, 30, 40);
        }
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Score: " + gameScore, 30, 30);
    }
    private void drawPlayer(Graphics2D g2) {
        HoppingPlayerBox playerBox = viewableHopperModel.getHoppingPlayerBox();
        Rectangle2D hoppingPlayerBox = new Rectangle2D.Double(playerBox.getPlayerX(),
                playerBox.getPlayerY(), playerBox.getWidth(), playerBox.getHeight());
        g2.setColor(colorTheme.getHopperPlayerColor());
        g2.fill(hoppingPlayerBox);
        g2.draw(hoppingPlayerBox);
        String playerSide = String.valueOf(playerBox.getSide());
        String playerPlatformNumber = String.valueOf(playerBox.getCurrentPlatformNum());
        if (viewableHopperModel.isDebugMode()) {
            g2.setColor(Color.BLACK);
            g2.drawString(playerPlatformNumber + playerSide, playerBox.getPlayerX() + 10,
                    (int) (playerBox.getPlayerY() + 10));
        }
    }

    private void drawGameOver(Graphics2D g2){
        String gameScore = String.valueOf(viewableHopperModel.getGameScore());
        String highScore = String.valueOf(viewableHopperModel.getHighScore());
        Rectangle2D gameOverScreen = new Rectangle2D.Double(50, 50, 500, 600);
        g2.setColor(colorTheme.getGameOverColor());
        g2.fill(gameOverScreen);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 40));
        g2.drawString("GameOver", 100, 250);
        g2.setFont(new Font("Arial", Font.ITALIC, 20));
        g2.drawString("Your score was: " + gameScore, 100, 330);
        g2.drawString("Your high score is: " + highScore, 100, 360);
        g2.drawString("Press 'enter' to play again", 100, 420);
    }

    private void drawGameStart(Graphics2D g2){
        Rectangle2D gameOverScreen = new Rectangle2D.Double(50, 50, 500, 600);
        g2.setColor(colorTheme.getGameOverColor());
        g2.fill(gameOverScreen);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 40));
        g2.drawString("Welcome to Hopper", 100, 300);
        g2.setFont(new Font("Arial", Font.ITALIC, 20));
        g2.drawString("Press 'enter' to play", 100, 330);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGame(g2);
    }
}