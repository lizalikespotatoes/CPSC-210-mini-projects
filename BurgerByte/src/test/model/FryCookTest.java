package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.FryCook.*;
import static org.junit.jupiter.api.Assertions.*;


public class FryCookTest {
    private FryCook frycook;

    @BeforeEach
    public void setUp() {
        frycook = new FryCook("SpongeBob SquarePants", 20);
    }

    @Test
    public void testConstructor() {
        assertEquals("SpongeBob SquarePants", frycook.getName());
        assertEquals(20, frycook.getAge());
        assertFalse(frycook.isGrillReady());
        assertFalse(frycook.isAtWork());
    }

    @Test
    public void testStartWork() {
        assertFalse(frycook.isAtWork());
        assertFalse(frycook.isGrillReady());
        frycook.startWork(4.31);
        assertTrue(frycook.isGrillReady());
        assertTrue(frycook.isGrillReady());
    }

    @Test
    public void testLeaveWork() {
        frycook.startWork(3.44);
        assertTrue(frycook.isGrillReady());
        assertTrue(frycook.isAtWork());
        frycook.leaveWork();
        assertFalse(frycook.isGrillReady());
        assertFalse(frycook.isAtWork());
    }

    @Test
    public void testComputeWage() {
        assertEquals(0, frycook.computeWage());
        frycook.startWork(3.14);
        assertEquals((WAGE + RETENTION_BONUS) * frycook.getHoursWorked(), frycook.computeWage());
    }
}