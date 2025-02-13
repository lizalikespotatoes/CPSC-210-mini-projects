package ca.ubc.cs.cpsc210.snake.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import ca.ubc.cs.cpsc210.snake.model.SnakeGame;

public class GamePanel extends JPanel {
    private static final Color GAME_OVER_COLOUR = new Color(80, 40, 80);
    private static final Color GAME_IN_PLAY_COLOUR = new Color(198, 198, 220);
    private SnakeGameRenderer renderer;
    private SnakeGame game;

    public GamePanel(SnakeGame game) {
        this.game = game;
        renderer = new SnakeGameRenderer(game);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(game.isOver() ? GAME_OVER_COLOUR : GAME_IN_PLAY_COLOUR);
        renderer.draw(g);
    }
}
