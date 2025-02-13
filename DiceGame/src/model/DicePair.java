package model;

public class DicePair {
    private Die die1;
    private Die die2;

    public DicePair() {
        die1 = new Die();
        die2 = new Die();
    }

    public int getTotal() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    public void roll() {
        die1.roll();
        die2.roll();
    }
}
