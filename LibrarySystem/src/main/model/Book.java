package model;

public class Book {

    private String title;
    private String author;
    private BookType type;
    private int year;
    private int edition;
    private boolean isOnLoan;

    // EFFECTS: constructs book with title, author, type, year of publication and edition
    public Book(String title, String author, BookType type, int year, int ed) {
        this.title = title; 
        this.author = author; 
        this.type = type; 
        this.year = year; 
        this.edition = ed; 
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author; 
    
    }

    public BookType getType() {
        return type; 
    }

    public int getYear() {
        return year;
    }

    public int getEdition() {
        return edition;
    }

    // MODIFIES: this
    // EFFECTS: sets this book to be not on loan
    public void notOnLoan() {
        this.isOnLoan = false;
    }

    // EFFECTS: return true if this book is on loan, else return false
    public boolean onLoan() {
        if(isOnLoan){
            return true;
        } else{ 
            return false;
        }
        
    }

    // MODIFIES: this
    // EFFECTS: set this book to be on loan
    public void nowOnLoan() {
        isOnLoan = true;
    }


}