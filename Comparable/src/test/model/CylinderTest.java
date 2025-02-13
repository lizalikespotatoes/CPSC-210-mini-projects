import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Cylinder;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {
    private Cylinder testCylinder;

    @BeforeEach
    void runBefore() {
        testCylinder = new Cylinder(1.0, 2.0);
    }

    @Test
    void testConstructor() {
        assertEquals(1.0, testCylinder.getRadius());
        assertEquals(2.0, testCylinder.getHeight());
    }

    @Test
    void testGetVolume() {
        assertEquals(7, testCylinder.getVolume());
        // test round up to 38
        Cylinder otherCylinder = new Cylinder(2.0, 3.0);
        assertEquals(38, otherCylinder.getVolume());
        // test round up to 2
        otherCylinder = new Cylinder(0.5, 2.0);
        assertEquals(2, otherCylinder.getVolume());
    }

    @Test
    void testCompareTo() {
        Cylinder otherCylinder = new Cylinder(1.0, 2.0);
        assertEquals(0, testCylinder.compareTo(otherCylinder));

        otherCylinder = new Cylinder(1.5, 2.0);
        assertEquals(-1, testCylinder.compareTo(otherCylinder));

        otherCylinder = new Cylinder(1.0, 1.5);
        assertEquals(1, testCylinder.compareTo(otherCylinder));
    }
}