package ca.ubc.cpsc210.paddleball.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import ca.ubc.cpsc210.paddleball.model.PBG;
import ca.ubc.cpsc210.paddleball.model.Ball;
import ca.ubc.cpsc210.paddleball.model.Paddle;

/*
 * The panel in which the game is rendered.
 */
public class GamePanel extends JPanel {
    private static final String OVER = "Game Over!";
    private static final String REPLAY = "R to replay";
    private PBG game;

    // Constructs a game panel
    // EFFECTS: sets size and background colour of panel,
    // updates this with the game to be displayed
    GamePanel(PBG g) {
        setPreferredSize(new Dimension(PBG.DIMENSIONX, PBG.DIMENSIONY));
        setBackground(Color.GRAY);
        this.game = g;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
        if (game.isOver()) {
            gameOver(g);
        }
    }

    // Draws the game
    // MODIFIES: g
    // EFFECTS: draws the game onto g
    private void drawGame(Graphics g) {
        drawPaddle(g);
        drawBall(g);
    }

    // Draw the paddle
    // MODIFIES: g
    // EFFECTS: draws the paddle onto g
    private void drawPaddle(Graphics g) {
        Paddle t = game.getPaddle();
        Color savedCol = g.getColor();
        g.setColor(Paddle.COLOR);
        g.fillRect(t.getPosX() - Paddle.WIDTH / 2, Paddle.Y_POS - Paddle.HEIGHT / 2, Paddle.WIDTH, Paddle.HEIGHT);
        g.setColor(savedCol);
    }

    // Draw the ball
    // MODIFIES: g
    // EFFECTS: draws the ball onto g
    private void drawBall(Graphics g) {
        Ball b = game.getBall();
        Color savedCol = g.getColor();
        g.setColor(Ball.COLOR);
        g.fillOval(b.getXPos() - Ball.SIZE / 2, b.getXPos() - Ball.SIZE / 2, Ball.SIZE, Ball.SIZE);
        g.setColor(savedCol);
    }

    // Draws the "game over" message and replay instructions
    // MODIFIES: g
    // EFFECTS: draws "game over" and replay instructions onto g
    private void gameOver(Graphics g) {
        Color saved = g.getColor();
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Arial", 20, 20));
        FontMetrics fm = g.getFontMetrics();
        centreString(OVER, g, fm, PBG.DIMENSIONY / 2);
        centreString(REPLAY, g, fm, PBG.DIMENSIONY / 2 + 50);
        g.setColor(saved);
    }

    // Centres a string on the screen
    // MODIFIES: g
    // EFFECTS: centres the string str horizontally onto g at vertical position y
    private void centreString(String str, Graphics g, FontMetrics fm, int y) {
        int width = fm.stringWidth(str);
        g.drawString(str, (PBG.DIMENSIONX - width) / 2, y);
    }
}
