package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;

/**
 * Represents a paddle
 */
public class Paddle {
    public static final int WIDTH = 26; // must be even integer
    public static final int HEIGHT = 10;
    public static final int DX = 3;
    public static final int Y_POS = PBG.DIMENSIONY - 40;
    public static final Color COLOR = new Color(250, 222, 54);

    private int wichWay;
    private int posX;

    // Construct a paddle.
    // EFFECTS: places paddle at position (x, Y_POS) moving right.
    public Paddle(int x) {
        this.posX = x;
        wichWay = 1;
    }

    public int getPosX() {
        return posX;
    }

    // Paddle moves to right
    // MODIFIES: this
    // EFFECTS: paddle is moving right
    public void moveRight() {
        wichWay = 1;
    }

    // Paddle moves to left
    // MODIFIES: this
    // EFFECTS: paddle is moving left
    public void moveLeft() {
        wichWay = -1;
    }

    // Updates the paddle on clock tick
    // MODIFIES: this
    // EFFECTS: paddle is moved DX units in whatever direction it is facing and is
    // constrained to remain within boundaries of game
    public void move() {
        posX = posX + wichWay * DX;
        handleBoundary();
    }

    // Constrains paddle so that it doesn't travel off sides of screen
    // MODIFIES: this
    // EFFECTS: paddle is constrained to remain within vertical boundaries of game
    private void handleBoundary() {
        if (posX - WIDTH / 2 < 0) {
            posX = WIDTH / 2;
        
        } else if (posX + WIDTH / 2 > PBG.DIMENSIONX) {
            posX = PBG.DIMENSIONX - WIDTH / 2;
        }
    }
}



