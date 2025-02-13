import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Box;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    private Box testBox;

    @BeforeEach
    void runBefore() {
        testBox = new Box(1.0, 2.0, 3.0);
    }

    @Test
    void testConstructor() {
        assertEquals(1.0, testBox.getLength());
        assertEquals(2.0, testBox.getWidth());
        assertEquals(3.0, testBox.getHeight());
    }

    @Test
    void testGetVolume() {
        assertEquals(6, testBox.getVolume());
        // test round up from 12.1 to 13
        Box otherBox = new Box(1.21, 2.5, 4.0);
        assertEquals(13, otherBox.getVolume());
        // test round up from 12.7 to 13
        otherBox = new Box(1.27, 4.0, 2.5);
        assertEquals(13, otherBox.getVolume());
    }

    @Test
    void testCompareTo() {
        Box otherBox = new Box(1.0, 2.0, 3.0);
        assertEquals(0, testBox.compareTo(otherBox));

        otherBox = new Box(1.5, 2.0, 4.0);
        assertEquals(-1, testBox.compareTo(otherBox));

        otherBox = new Box(1.0, 1.5, 2.0);
        assertEquals(1, testBox.compareTo(otherBox));
    }
}