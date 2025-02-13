package model;

public class Box implements ComparableByVolume{
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
    @Override
    // EFFECTS: returns the volume of the box, rounded up to the nearest integer
    public int getVolume() {
        return (int) Math.ceil(length * width * height);
    }

    @Override
    // EFFECTS: returns 1 if this box has a greater volume than other box,
    //          -1 if this box has a smaller volume than other box,
    //           0 if this box has the same volume as other box
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
