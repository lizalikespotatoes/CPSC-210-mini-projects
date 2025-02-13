package model;

public class Cashier extends Employee {

    public static final double WAGE = 6.50;
    private boolean isRegisterOpen;

    // EFFECTS: constructs cashier with given name & age that is not at work and has not worked any hours;
    //          register is not open
    public Cashier(String name, int age) {
        super(name, age);
        this.isRegisterOpen = false;
       
    }
    
    //getters 

    public boolean isRegisterOpen(){ 
        return isRegisterOpen;
    }

    // MODIFIES: this
    // EFFECTS: records shift length, marks cashier as at work, and opens the register

    public void startWork(double shiftLength) {
        this.shiftLength = shiftLength;
        this.isRegisterOpen = true;
        this.atWork = true;
    }

    // MODIFIES: this
    // EFFECTS: logs hours worked (based on current shift length), marks cashier as not at work,
    //          and closes register
    
    public void leaveWork() {
        isRegisterOpen = false;
        atWork = false;
        logHoursWorked();
    }

    private void logHoursWorked() {
        hoursWorked = shiftLength; 
    }


    // EFFECTS: returns wages for the day
    public double computeWage() {
        return hoursWorked * WAGE;
    }
}