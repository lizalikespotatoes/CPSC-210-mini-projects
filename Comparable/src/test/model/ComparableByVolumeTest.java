import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Cylinder;
import model.Box;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComparableByVolumeTest {
   private Box testBox;
   private Cylinder testCylinder;

   @BeforeEach
   void runBefore() {
       testBox = new Box(1.0, 2.0, 3.0);
       testCylinder = new Cylinder(1.0, 2.0);
   }

   @Test
   void testCompareTo() {
       assertEquals(-1, testBox.compareTo(testCylinder));
       assertEquals(1, testCylinder.compareTo(testBox));
       assertEquals(0, testBox.compareTo(testBox));
       assertEquals(0, testCylinder.compareTo(testCylinder));
   }
}
