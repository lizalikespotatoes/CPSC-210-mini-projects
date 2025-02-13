package model;

import java.util.LinkedList;
import java.util.List;

public class BurgerByte {

    private String location;
    private List<Cashier> cashiers;
    private List<FryCook> fryCooks;
    private boolean isOpen;

    // EFFECTS: constructs BurgerByte restaurant at given location with no staff and closed
    public BurgerByte(String locn) {
        location = locn;
        cashiers = new LinkedList<>();
        fryCooks = new LinkedList<>();
    }

    // getters
    public String getLocation() {
        return location;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public List<FryCook> getFryCooks() {
        return fryCooks;
    }

    public boolean isOpen() {
        return isOpen;
    }

    // EFFECTS: opens this restaurant
    public void openRestaurant() {
        isOpen = true;
    }

    // EFFECTS: closes this restaurant, and sends all employees home (off work)
    public void closeRestaurant() {
        isOpen = false;
        for (Employee c : cashiers) {
            c.leaveWork();
        }
        for (FryCook fc : fryCooks) {
            fc.leaveWork();
        }
    }

    // REQUIRES: c must not be in this restaurant's list of cashiers
    // MODIFIES: this
    // EFFECTS: adds the given cashier to list of cashiers
    public void addCashier(Cashier c) {
        cashiers.add(c);
    }

    // MODIFIES: this
    // EFFECTS: removes the given cashier from list of cashiers
    public void removeCashier(Employee c) {
        cashiers.remove(c);
    }

    // REQUIRES: fc must not be in this restaurant's list of fry cooks
    // MODIFIES: this
    // EFFECTS: adds the given fry cook to list of fry cooks
    public void addFryCook(FryCook fc) {
        fryCooks.add(fc);
    }

    // MODIFIES: this
    // EFFECTS: removes the given fry cook from list of fry cooks
    public void removeFrycook(FryCook fc) {
        fryCooks.remove(fc);
    }

    // EFFECTS: returns total wages for all employees (cashiers and fry cooks)
    public double computeStaffWages() {
        double totalWages = 0.0;
        for (Employee c : cashiers) {
            totalWages += c.computeWage();
        }
        for (FryCook fc : fryCooks) {
            totalWages += fc.computeWage();
        }
        return totalWages;
    }
}