package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.EventType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    private Event ev1;
    private Event ev2;
    private Event ev3;
    private Event ev4;

    @BeforeEach
    public void setUp() {
        ev1 = new Event("John's Wedding", "May 20", "Stanley Park", WEDDING);
        ev2 = new Event("Celina's Party", "May 11", "2298 West 4th Avenue", PARTY);
        ev3 = new Event("Anthony's Birthday", "August 29", "10109 University Blvd", BIRTHDAY);
        ev4 = new Event("Bill's Lecture", "May 4", "2366 main.Main Mall", SCHOOL);
    }

    @Test
    public void testGetters() {
        assertEquals("John's Wedding", ev1.getName());
        assertEquals(WEDDING, ev1.getEventType());
        assertEquals("May 20", ev1.getDate());
        assertEquals("Celina's Party", ev2.getName());
        assertEquals(PARTY, ev2.getEventType());
        assertEquals(BIRTHDAY, ev3.getEventType());
        assertEquals(SCHOOL, ev4.getEventType());
    }


}