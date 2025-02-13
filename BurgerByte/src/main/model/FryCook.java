package model;

public class FryCook extends Employee{

    public static final double RETENTION_BONUS = 1.25;
    public static final double WAGE = 6.50;
    private boolean isGrillReady;

    // EFFECTS: constructs cook with given name & age that is not at work and has not worked any hours;
    //          grill is not ready
    public FryCook(String name, int age) {
        super(name, age);
        this.isGrillReady = false;
       
    }

    // getters
    public boolean isGrillReady() {
        return isGrillReady;
    }

    // MODIFIES: this
    // EFFECTS: records shift length, marks cook as at work, and makes the grill ready
    public void startWork(double shiftLength) {
        this.shiftLength = shiftLength;
        this.isGrillReady = true;
        this.atWork = true;
    }

    // MODIFIES: this
    // EFFECTS: logs hours worked (based on current shift length), marks cook as not at work,
    //          and closes the grill
    public void leaveWork() {
        isGrillReady = false;
        atWork = false;
        logHoursWorked();
            }
        
    private void logHoursWorked() {
        hoursWorked = shiftLength; 
    }
        
            // EFFECTS: returns wages for the day
    public double computeWage() {
        return (hoursWorked * (WAGE + RETENTION_BONUS));
    }


}