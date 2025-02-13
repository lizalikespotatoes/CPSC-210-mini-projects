package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.EventType.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyProfileTest {

    private MyProfile friend1;
    private MyProfile friend2;
    private MyProfile friend3;
    private MyProfile friend4;
    private MyProfile friend5;
    private MyProfile friend6;
    private MyProfile friend7;
    private MyProfile friend8;
    private MyProfile mainProfile;
    private Event ev1;
    private Event ev2;
    private Event ev3;
    private Event ev4;
    private Event ev5;
    private Event ev6;

    @BeforeEach
    public void setUp() {
        mainProfile = new MyProfile("Johnny Appleseed", 20, "Coquitlam", "SPL");

        initializeFriends();

        mainProfile.addFriend(friend1);
        mainProfile.addFriend(friend2);
        mainProfile.addFriend(friend3);
        mainProfile.addFriend(friend4);
        mainProfile.addFriend(friend5);
        friend5.addFriend(friend6);
        friend6.addFriend(friend7);

        initializeEvents();

        mainProfile.addEvent(ev1);
        mainProfile.addEvent(ev2);
        mainProfile.addEvent(ev3);
        mainProfile.addEvent(ev4);
        mainProfile.addEvent(ev5);
    }

    private void initializeEvents() {
        ev1 = new Event("John's Wedding", "May 20", "Coquitlam", WEDDING);
        ev2 = new Event("Celina's Party", "May 11", "2298 West 4th Avenue", PARTY);
        ev3 = new Event("Anthony's Birthday", "August 29", "Coquitlam", BIRTHDAY);
        ev4 = new Event("Bill's Lecture", "May 4", "2366 Main Mall", SCHOOL);
        ev5 = new Event("Mei's Party", "May 15", "5352 West 45th Avenue", PARTY);
        ev6 = new Event("Liza's Party", "Jan 15", "51935 lower mall", ENGAGEMENT);
    }

    private void initializeFriends() {
        friend1 = new MyProfile("Paul Carter", 30, "London", "Network Systems");
        friend2 = new MyProfile("Alan Turing", 24, "Coquitlam", "A Thinking Ape");
        friend3 = new MyProfile("Ada Lovelace", 40, "Coquitlam", "AppNeta");
        friend4 = new MyProfile("Alfonzo Church", 50, "New York City", "NYU Research");
        friend5 = new MyProfile("Bob Ross", 44, "Chicago", "CBS");
        friend6 = new MyProfile("John Carter", 33, "Bellevue", "Microsoft");
        friend7 = new MyProfile("Eric Hamber", 23, "Vancouver", "UBC");
        friend8 = new MyProfile("Liza Patel", 18, "Vancouver", "None");
    }

    @Test
    public void testConstructor() {
        assertEquals("Alan Turing", friend2.getName());
        assertEquals(24, friend2.getAge());
        assertEquals("Coquitlam", friend2.getCurrentLocation());
        assertEquals("A Thinking Ape", friend2.getWorkPlace());
    }

    @Test
    public void testCanFindPerson() { 
        assertTrue(mainProfile.canFindPerson("John Carter"));
        assertFalse(mainProfile.canFindPerson("Nick Jonas"));
        assertTrue(mainProfile.canFindPerson("Eric Hamber"));
        assertTrue(mainProfile.canFindPerson("Alan Turing"));
    }

    @Test
    public void testunFriend() {
        assertTrue(mainProfile.getFriendsList().contains(friend3));
        assertTrue(mainProfile.unFriend(friend3.getName()));
        assertFalse(mainProfile.getFriendsList().contains(friend3));
        assertFalse(mainProfile.unFriend("Linda Bob"));
    }

    @Test
    public void testremoveEvent() {
        assertTrue(mainProfile.getEventList().contains(ev4));
        assertTrue(mainProfile.removeEvent(ev4.getName()));
        assertFalse(mainProfile.getEventList().contains(ev4));
        assertFalse(mainProfile.removeEvent(ev4.getName()));
        assertFalse(mainProfile.removeEvent("Anthony's Dance Party"));
    }

    @Test
    public void testeventNumNearMe() {
        assertEquals(2, mainProfile.numNearbyEvents());
        mainProfile.removeEvent("John's Wedding");
        assertEquals(1, mainProfile.numNearbyEvents());
        mainProfile.removeEvent("Anthony's Birthday");
        assertEquals(0, mainProfile.numNearbyEvents());
    }

    @Test
    public void testupcomingEventNum() {
        assertEquals(5, mainProfile.numUpcomingEvents());
        mainProfile.removeEvent("Bill's Lecture");
        assertEquals(4, mainProfile.numUpcomingEvents());
    }

    @Test

    public void testNumEventsOfType() {
        assertEquals(1, mainProfile.numEventsOfType(BIRTHDAY));
        assertEquals(2, mainProfile.numEventsOfType(PARTY));
        assertEquals(0, mainProfile.numEventsOfType(ENGAGEMENT));
    }

    @Test

    public void testaddEvent() {
        // add an event that is not already there and check that it adds  
        
        assertFalse(mainProfile.getEventList().contains(ev6));
        mainProfile.addEvent(ev6);
        assertTrue(mainProfile.getEventList().contains(ev6));

        // adding a friend that is already there and checking that it only added once 
        assertTrue(mainProfile.getEventList().contains(ev6));
        mainProfile.addEvent(ev6);
        int count = 0;
        for (Event event : mainProfile.getEventList()){
            if (event.getEventType().equals(ev6.getEventType())){
                count += 1; 
            }
        }
         assertEquals(1,count); 
    }

    @Test

    public void testAddFriend() {
        // adding a friend that is not already there and checking it adds 
        assertFalse(mainProfile.getFriendsList().contains(friend8));
        mainProfile.addFriend(friend8);
        assertTrue(mainProfile.getFriendsList().contains(friend8));

        // adding a friend that is already there and checking that it only added once 
        assertTrue(mainProfile.getFriendsList().contains(friend8));
        mainProfile.addFriend(friend8);
        int count = 0;
        for (MyProfile friend : mainProfile.getFriendsList()){
            if (friend.getName().equals(friend8.getName())){
                count += 1; 
            }
        }
         assertEquals(1,count);  
    }
}