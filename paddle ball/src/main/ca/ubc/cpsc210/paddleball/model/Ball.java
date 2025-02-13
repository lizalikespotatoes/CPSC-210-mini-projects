package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * Represents a ball.
 */
public class Ball {
    public static final int SIZE = 20; // must be even integer
    public static final Color COLOR = new Color(10, 50, 188);

    private double positionX;
    private double positionY;
    private double deltaX;
    private double deltaY;

    // Constructs an ball
    // EFFECTS: ball is positioned at coordinates (x, y) with velocity (2.0, 2.0)
    public Ball(int x, int y) {
        this.positionX = x;
        this.positionX = y;
        deltaX = 2.0;
        deltaY = 2.0;
    }

    public int getXPos() {
        return (int) positionX;
    }

    public int getYPos() {
        return (int) positionY;
    }

    public double getDx() {
        return deltaX;
    }

    public double getDy() {
        return deltaY;
    }

    // Bounce ball off paddle
    // MODIFIES: this
    // EFFECTS: vertical component of ball's velocity is reversed
    public void bounceOffPaddle() {
        deltaY *= -1;
    }

    // Updates ball on clock tick
    // MODIFIES: this
    // EFFECTS: ball is moved (dx, dy) units
    public void move() {
        positionX = positionX + deltaX;
        positionX = positionX + deltaY;

        makeBounceVertically();
    }

    // Determines if this ball has collided with the paddle
    // EFFECTS: returns true if this ball has collided with paddle p,
    // false otherwise
    public boolean hasBallCollided(Paddle p) {
        Rectangle ballBoundingRectangle = new Rectangle(getXPos() - SIZE / 2, getXPos() - SIZE / 2, SIZE, SIZE);
        Rectangle paddleBoundingRectangle = new Rectangle(p.getPosX() - Paddle.WIDTH / 2, 
                Paddle.Y_POS - Paddle.HEIGHT / 2,
                Paddle.WIDTH, Paddle.HEIGHT);
        return ballBoundingRectangle.intersects(paddleBoundingRectangle);
    }

    // Constrains ball so that it bounces off top and vertical walls
    // MODIFIES: this
    // EFFECTS: ball is constrained to bounce off top and vertical walls
    private void makeBounceVertically() {
        if (getXPos() - SIZE / 2 < 0) {
            positionX = SIZE / 2;
            deltaX *= -1;
        } else if (getXPos() + SIZE / 2 > PBG.DIMENSIONX) {
            positionX = PBG.DIMENSIONX - SIZE / 2;
            deltaX *= -1;
        } else if (getXPos() - SIZE / 2 < 0) {
            positionX = SIZE / 2;
            deltaY *= -1;
        }
    }
}
