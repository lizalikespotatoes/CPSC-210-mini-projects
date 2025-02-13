package model;


public class Animal {

    private String name;
    private String country;
    private int age;
    private double weight;

    public Animal(String nm, String ct, int age, double wgt) {
        this.name = nm;
        this.country = ct;
        this.age = age;
        this.weight = wgt;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
    
}
