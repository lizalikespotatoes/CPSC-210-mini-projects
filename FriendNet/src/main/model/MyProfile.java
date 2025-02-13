package model;

import java.util.ArrayList;
import java.util.List;

public class MyProfile {

    private String name;
    private int age;
    private String currentLocation;
    private String workPlace;
    private List<MyProfile> friendsList;
    private List<Event> upcomingEvents;

    // EFFECTS: constructs profile with name, age, current location and workplace,
    // having empty list of upcoming events and empty list of friends
    public MyProfile(String nm, int age, String locn, String work) {
        this.name = nm; 
        this.age= age; 
        currentLocation = locn; 
        workPlace = work; 
        friendsList = new ArrayList<MyProfile>(); 
        upcomingEvents = new ArrayList<Event>(); 
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getWorkPlace() {
        return workPlace;

    }

    public int numUpcomingEvents() {
        return upcomingEvents.size();

    }

    public List<MyProfile> getFriendsList() {
        return friendsList;
    }

    public List<Event> getEventList() {
        return upcomingEvents;
    }

    // REQUIRES: f is not already in list of friends
    // MODIFIES: this
    // EFFECTS: adds f to list of friends
    public void addFriend(MyProfile f) {
        if (!friendsList.contains(f)) {
            friendsList.add(f);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes friend with the given name from this profile;
    //          returns true if removal is successful, otherwise false
    public boolean unFriend(String nm) {
        for (MyProfile friend : friendsList) {
            if (friend.getName().equals(nm)) {
                friendsList.remove(friend); 
                return true; 
            }
        }

        return false;
    }

    // REQUIRES: ev is not in list of upcoming events
    // MODIFIES: this
    // EFFECTS: adds the given event to the list of upcoming events
    public void addEvent(Event ev) {
        if(!upcomingEvents.contains(ev)){
            upcomingEvents.add(ev);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes an event with the given name; returns true if removal is successful;
    //          otherwise false
    public boolean removeEvent(String nm) {
        for (Event ev : upcomingEvents){
            if (ev.getName().equals(nm)){
                upcomingEvents.remove(ev);
                return true; 
            }
        }

        return false; 
    }

    // EFFECTS: returns the number of events at location of this profile
    public int numNearbyEvents() {
        int count = 0; 
        for (Event ev : upcomingEvents){
            if (ev.getLocation().equals(currentLocation)){
                count += 1; 
            }   
        }
        return count; 
    }

    // EFFECTS: returns the number of events of type et
    public int numEventsOfType(EventType et) {
        int count = 0; 
        for (Event ev: upcomingEvents) {
            if(ev.getEventType().equals(et)){
                count += 1; 
            }
        }
        return count;
    }

    // EFFECTS: produces true if this profile has a friend with the given name,
    //          OR if any of this profile's friends has a friend with the given name
    //          Hint: use recursion!
    public boolean canFindPerson(String name) {
        for (MyProfile friend : friendsList) {
            if (friend.getName().equals(name) || friend.canFindPerson(name)) {
                return true;
            }
        }

        return false;
    }
}
