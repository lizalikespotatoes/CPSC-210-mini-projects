package model;

import java.util.ArrayList;
import java.util.List;

public class Zookeeper{

    private String name;
    private int age;
    private List<Animal> animalList;
    private Animal favourite;

   
    public Zookeeper(String name, int age) {
        this.name = name;
        this.age = age;
        this.animalList = new ArrayList<>(); // Initialize the list
    }

    

    public void setFavorite(Animal animal){
        favourite = animal; 
    }

    public void addToList(Animal a){
        animalList.add(a);
    }

    // getters 

    public String getName() {
        return name; 
    }

    public int getAge(){ 
        return age; 
    }

    public Animal getFav(){
        return favourite;
    }

    public List<Animal> getAnimalList(){
        return animalList;
    }
}