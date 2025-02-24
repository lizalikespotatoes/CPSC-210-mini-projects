package ca.ubc.cs.cpsc210.snake.ui;

import ca.ubc.cs.cpsc210.snake.model.Cell;
import ca.ubc.cs.cpsc210.snake.model.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// Represents the main frame in which the Snake game will appear
class SnakeApp extends JFrame {
    private static final int WIDTH = SnakeGame.BOARD_COLS * Cell.CELL_PIXELS;
    private static final int HEIGHT = SnakeGame.BOARD_ROWS * Cell.CELL_PIXELS;
    private static final int INTERVAL = 500;
    private SnakeGame game;
    private JPanel gamePanel;
    private ScorePanel scorePanel;

    // EFFECTS: sets up window in which Snake game will be played
    SnakeApp() {
        super("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        game = new SnakeGame();
        gamePanel = new GamePanel(game);
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        scorePanel = new ScorePanel();
        addKeyListener(new KeyHandler());
        add(gamePanel);
        add(scorePanel, BorderLayout.NORTH);
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer();
    }

    // EFFECTS: initializes a timer that updates game each
    //          INTERVAL milliseconds
    private void addTimer() {
        final Timer t = new Timer(INTERVAL, null);
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (game.isOver()) {
                    t.stop();
                } else {
                    game.update();
                    scorePanel.update(game.getSnakeNutritionConsumed());
                    gamePanel.repaint();
                }
            }
        });

        t.start();
    }

    // MODIFIES: this
    // EFFECTS:  frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    // Represents a key handler that responds to keyboard events
    private class KeyHandler extends KeyAdapter {
        @Override
        // MODIFIES: this
        // EFFECTS:  updates game in response to a keyboard event
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_KP_LEFT:
                    game.rotateSnakeLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_KP_RIGHT:
                    game.rotateSnakeRight();
                    break;
                default:
                    break;
            }
        }
    }

    // Play the game
    public static void main(String[] args) {
        new SnakeApp();
    }
}
