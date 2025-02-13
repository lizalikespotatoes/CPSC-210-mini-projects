package model;

import java.util.List;

public class Band {

    private String name;
    private double totalEarned;
    private double currentFunds;
    private List<String> members;
    private int numShowsPlayed;

    // EFFECTS: constructs band with name, having no earnings, no current funds, no members, and no shows played
    public Band(String name) {
        // TODO: complete the implementation of this method
    }

    // getters
    public String getName() {
        // TODO: complete the implementation of this method
        return null;
    }

    public double getTotalEarned() {
        // TODO: complete the implementation of this method
        return 0.0;
    }

    public double getCurrentFunds() {
        // TODO: complete the implementation of this method
        return 0.0;
    }

    public List<String> getMembers() {
        // TODO: complete the implementation of this method
        return null;
    }

    public int getNumShowsPlayed() {
        // TODO: complete the implementation of this method
        return 0;
    }

    // MODIFIES: this
    // EFFECTS: adds a member with the given name to the band
    public void addMember(String name) {
        // TODO: complete the implementation of this method
    }

    // MODIFIES: this
    // EFFECTS: given an amount the band will be paid for the show, update
    //          the current funds and total earned by the amount, and add one to
    //          the number of shows played.
    public void playGig(double amt) {
        // TODO: complete the implementation of this method

    }

    // MODIFIES: this
    // EFFECTS: pays the given amount to each band member, the total paid
    //          is subtracted from the current funds. If current funds are
    //          insufficient, nothing happens.
    public void payMembers(double amt) {
        // TODO: complete the implementation of this method
    }

    // REQUIRES: getNumShowsPlayed() > 0
    // EFFECTS: computes the average amount the band is paid per show
    public double averagePerShow() {
        // TODO: complete the implementation of this method
        return 0.0;
    }


}
