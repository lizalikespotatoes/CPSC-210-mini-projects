package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import model.Zookeeper;

public class ZookeeperTest {
   
    private Zookeeper zooKeeper; 
    private Animal whale; 
    private Animal snake;  

    @Before
    public void setUp(){ 
        zooKeeper = new Zookeeper("Liza", 18); 
        whale = new Whale("bobby", "Kenya", 1, 100, false, 10);
        snake = new Snake("Bob", "Kenya", 1, 100, 100, true);
        zooKeeper.setFavorite(whale); 
    }

    @Test
    public void constructorZookeeperTest(){ 
        assertTrue(zooKeeper.getName().equals("Liza"));  
        assertEquals(18, zooKeeper.getAge());

    }

    @Test
    public void setFavoriteZookeeperTest(){
        assertTrue(zooKeeper.getFav().getName().equals("bobby")); 
        zooKeeper.setFavorite(snake);
        assertTrue(zooKeeper.getFav().getName().equals("Bob"));
 
    }

    @Test
    public void addToListZookeeperTest(){
        zooKeeper.addToList(snake);
        assertTrue(zooKeeper.getAnimalList().get(0).equals(snake));
        zooKeeper.addToList(whale);
        assertTrue(zooKeeper.getAnimalList().get(1).equals(whale));

 
    }



}