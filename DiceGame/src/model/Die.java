package model;

import java.util.Random;

public class Die {
    private static final int MAX_ROLL = 6;
    private static final Random RND = new Random();
    private int faceValue;

    public Die() {
        roll();
    }

    public int getFaceValue() {
        return this.faceValue;
    }

    // generate an integer in the range 1 to MAX_ROLL
    // and return it
    public void roll() {
        this.faceValue = RND.nextInt(MAX_ROLL + 1);
    }
}
