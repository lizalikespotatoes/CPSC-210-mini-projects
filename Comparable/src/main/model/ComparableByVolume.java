package model;

public interface ComparableByVolume {
 

    // EFFECTS: returns the volume of the container, rounded up to the nearest integer
    public int getVolume(); 

    // EFFECTS: returns 1 if this container has a greater volume than other container,
    //          -1 if this container has a smaller volume than other container,
    //           0 if this container has the same volume as other box
    public int compareTo(ComparableByVolume other); 
}
