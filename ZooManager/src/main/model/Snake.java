package model;

public class Snake extends Animal{

  
    private double length;
    private boolean venom;

    public Snake(String nm, String ct, int age, double wgt, double len, boolean vn) {
        super(nm, ct, age, wgt);
        length = len; 
        venom = vn; 
    }

    // getters
    public double getLength() {
        return length;
    }

    public boolean isVenom() {
        return venom;
    }


}