package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Cashier.WAGE;
import static org.junit.jupiter.api.Assertions.*;


public class CashierTest {
    private Cashier cashier;

    @BeforeEach
    public void setUp() {
        cashier = new Cashier("SquidWard Tentacles", 21);
    }

    @Test
    public void testConstructor() {
        assertEquals("SquidWard Tentacles", cashier.getName());
        assertEquals(21, cashier.getAge());
        assertFalse(cashier.isRegisterOpen());
        assertFalse(cashier.isAtWork());
    }

    @Test
    public void testStartWork() {
        assertFalse(cashier.isRegisterOpen());
        assertFalse(cashier.isAtWork());
        cashier.startWork(10.45);
        assertEquals(WAGE * cashier.getHoursWorked(), cashier.computeWage(),0.05);
        assertTrue(cashier.isRegisterOpen());
        assertTrue(cashier.isAtWork());
    }

    @Test
    public void testLeaveWork() {
        cashier.startWork(4.50);
        assertTrue(cashier.isAtWork());
        assertTrue(cashier.isRegisterOpen());
        cashier.leaveWork();
        assertFalse(cashier.isAtWork());
        assertFalse(cashier.isRegisterOpen());
    }

    @Test
    public void testComputeWage() {
        assertEquals(0, cashier.computeWage());
        cashier.startWork(3.47);
        assertEquals(WAGE * cashier.getHoursWorked(), cashier.computeWage());
    }
}