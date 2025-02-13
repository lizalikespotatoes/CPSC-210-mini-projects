package model;

public class Cylinder implements ComparableByVolume{
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    @Override
    // EFFECTS: returns the volume of the cylinder, rounded up to the nearest integer
    public int getVolume() {
        return (int) Math.ceil(Math.PI * radius * radius * height);
    }

    @Override
    // EFFECTS: returns 1 if this cylinder has a greater volume than other cylinder,
    //         -1 if this cylinder has a smaller volume than other cylinder,
    //          0 if this cylinder has the same volume as other cylinder
    public int compareTo(ComparableByVolume other) {
        if (this.getVolume() > other.getVolume()) {
            return 1;
        } else if (this.getVolume() < other.getVolume()) {
            return -1;
        } else {
            return 0;
        }
    }
}
