package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BurgerByteTest {

    private BurgerByte restaurant;
    private FryCook frycook;
    private Cashier cashier;

    @BeforeEach
    public void setUp() {
        restaurant = new BurgerByte("Water's Edge");
        frycook = new FryCook("SpongeBob SquarePants", 20);
        cashier = new Cashier("SquidWard Tentacles", 21);
    }

    @Test
    public void testConstructor() {
        assertEquals("Water's Edge", restaurant.getLocation());
        assertEquals(0, restaurant.getCashiers().size());
        assertEquals(0, restaurant.getFryCooks().size());
        assertFalse(restaurant.isOpen());
    }

    @Test
    public void testAdd() {
        restaurant.addFryCook(frycook);
        restaurant.addCashier(cashier);
        assertEquals(1, restaurant.getCashiers().size());
        assertEquals(1, restaurant.getFryCooks().size());
        assertTrue(restaurant.getFryCooks().contains(frycook));
        assertTrue(restaurant.getCashiers().contains(cashier));
    }

    @Test
    public void testOpenRestaurant() {
        assertFalse(restaurant.isOpen());
        restaurant.openRestaurant();
        assertTrue(restaurant.isOpen());
    }

    @Test
    public void testCloseRestaurant() {
        restaurant.addFryCook(frycook);
        restaurant.addCashier(cashier);
        frycook.startWork(10.00);
        cashier.startWork(5.00);
        restaurant.closeRestaurant();
        assertFalse(frycook.isAtWork());
        assertFalse(cashier.isAtWork());
    }

    @Test
    public void testRemove() {
        restaurant.addFryCook(frycook);
        restaurant.addCashier(cashier);
        restaurant.removeFrycook(frycook);
        restaurant.removeCashier(cashier);
        assertTrue(restaurant.getFryCooks().isEmpty());
        assertTrue(restaurant.getCashiers().isEmpty());
    }

    @Test
    public void testComputeStaffWages() {
        restaurant.addFryCook(frycook);
        restaurant.addCashier(cashier);
        frycook.startWork(10.00);
        cashier.startWork(4.50);
        frycook.leaveWork();
        cashier.leaveWork();
        assertEquals(10.00 * (FryCook.WAGE + FryCook.RETENTION_BONUS)
                + 4.50 * (Employee.WAGE), restaurant.computeStaffWages());
    }
}