package model;

public abstract class  Employee {

    public static final double RETENTION_BONUS = 1.25;
    public static final double WAGE = 6.50;
    String name; 
    int age; 
    Boolean atWork; 
    double hoursWorked;
    double shiftLength; 

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.atWork = false;
        this.hoursWorked = 0;
        this.shiftLength = 0;
    }

    // getters
    
    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public double getHoursWorked() {
        return hoursWorked;
    }

  
    public boolean isAtWork() {
        return atWork;
    }

    public void leaveWork() {
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