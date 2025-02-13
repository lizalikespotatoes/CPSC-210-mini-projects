package model;

public class Librarian {

    private String name;
    private int age;
    private Book favBook;

    // EFFECTS: constructs librarian with name, age and favourite book
    public Librarian(String name, int age, Book bk) {
        this.name = name; 
        this.age = age; 
        this.favBook = bk; 
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Book getFavBook() {
        return favBook;
    }
}
