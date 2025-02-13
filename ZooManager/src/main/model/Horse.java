package model;

public class Horse extends Animal{


    private double topSpeed;

    public Horse(String nm, String ct, int age, double wgt, double ts) {
        super(nm, ct, age, wgt);
    }

    public double gettopSpeed(){ 
        return topSpeed;
    }


}