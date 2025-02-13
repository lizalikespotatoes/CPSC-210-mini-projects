package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BandTest {

    private Band band;

    @BeforeEach
    public void setUp() {
        band = new Band("April Fools Childrenhood");
    }

    @Test
    public void testConstructor() {
        assertEquals("April Fools Childrenhood", band.getName());
        assertEquals(0, band.getMembers().size());
        assertEquals(0.0, band.getTotalEarned());
        assertEquals(0.0, band.getCurrentFunds());
        assertEquals(0, band.getNumShowsPlayed());
    }

    @Test
    public void testAddMembers() {
        band.addMember("David Cowling");
        assertEquals(1, band.getMembers().size());
        band.addMember("Emma Citrine");
        assertEquals(2, band.getMembers().size());
        assertTrue(band.getMembers().contains("David Cowling"));
        assertTrue(band.getMembers().contains("Emma Citrine"));
        assertFalse(band.getMembers().contains("Erika Thompson"));
    }

    @Test
    public void testPlayGig() {
        band.playGig(100.0);
        assertEquals(100.0, band.getTotalEarned());
        assertEquals(100.0, band.getCurrentFunds());

        band.playGig(175.50);
        assertEquals(275.50, band.getTotalEarned());
        assertEquals(275.50, band.getCurrentFunds());
    }

    @Test
    public void testPayMembers() {
        band.addMember("Raeanne");
        band.playGig(100.0);
        band.payMembers(20);
        assertEquals(80.0, band.getCurrentFunds());

        band.addMember("Sazi");
        band.payMembers(50.0);
        assertEquals(80.0, band.getCurrentFunds());

        band.payMembers(30.0);
        assertEquals(20.0, band.getCurrentFunds());
    }

    @Test
    public void testAverageMoney() {
        band.playGig(100.0);
        band.playGig(25.75);
        band.playGig(33.33);
        band.playGig(145.0);
        assertEquals((100.0 + 25.75 + 33.33 + 145.0) / 4, band.averagePerShow());
    }


}
