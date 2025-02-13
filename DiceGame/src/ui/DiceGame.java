package ui;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import model.DicePair;

public class DiceGame {
    private static final int WINNING_ROLL = 12;
    private static final int MAX_ROLLS = 6;
    private DicePair dp;

    public DiceGame() {
        dp = new DicePair();
    }

    // player wins if they roll the WINNING_ROLL in no more
    // than MAX_ROLLS attempts, otherwise they lose
    public void play() {
        int numRolls = 0;  // count number of rolls so far

        do {
            dp.roll();
            numRolls += 1; 
            printTotal(dp.getTotal());
        } while (rollAgain(numRolls));

        printResult(dp.getTotal());
    }

    // return true if we should roll again (haven't rolled the winning
    // roll and number of rolls is still less than maximum allowed)
    private boolean rollAgain(int numRolls) {
        return dp.getTotal() != WINNING_ROLL && numRolls < MAX_ROLLS;
    }

    private void printTotal(int total) {
        System.out.println("You rolled a " + total);
    }

    private void printResult(int total) {
        if (total == 12) {
            System.out.println("You won!");
        } else {
            System.out.println("Sorry, you lost :-(");
        }
    }
}
