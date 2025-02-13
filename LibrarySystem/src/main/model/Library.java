package model;

import static model.BookType.COOKING;
import static model.BookType.NONFICTION;
import static model.BookType.TEXTBOOK;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library {


        private Librarian manager;
        private String name;
        private List<Book> referenceBooks;
        private List<Book> fictionBooks;
        private List<Book> nonfictionBooks;
        private List<Book> textBooks;
        private List<Book> cookBooks;
    
        // EFFECTS: constructs library with name and manager
        public Library(String nm, Librarian manager) {
            name = nm; 
            this.manager = manager; 
            referenceBooks = new ArrayList<>(); 
            fictionBooks = new ArrayList<>(); 
            nonfictionBooks = new ArrayList<>(); 
            textBooks = new ArrayList<>(); 
            cookBooks = new ArrayList<>(); 
        }
    
        // getters
        public String getName() {
            return name;
        }
    
        public Librarian getManager() {
            return manager;
        }
    
        // MODIFIES: this
        // EFFECTS: stores the given Book bk
        public void storeBook(Book bk) {

            BookType book = bk.getType();

            if (book.equals(BookType.REFERENCE)) {
                referenceBooks.add(bk);

            } else if (book.equals(BookType.FICTION)){ 
                fictionBooks.add(bk);

            } else if (book.equals(NONFICTION)) {
                nonfictionBooks.add(bk);

            }else if (book.equals(TEXTBOOK)) {
                textBooks.add(bk);

            } else if (book.equals(COOKING)) {
                cookBooks.add(bk);

            } else {
                System.out.println("Book type does not match any of the categories"); 
            }
        }
    

    // EFFECTS: return true if bk is in this library's catalogue
    //          regardless of its loan status, else return false
    public boolean inCatalogue(Book bk) {
        if(referenceBooks.contains(bk) || fictionBooks.contains(bk) || nonfictionBooks.contains(bk) 
        || textBooks.contains(bk) || cookBooks.contains(bk)){
            return true;
        } else {
            return false; 
        }
    }

    // EFFECTS: return true if bk is available to loan
    // Hint: What requirements should a book meet to be available for loan?
    public boolean canLoan(Book bk) {
        return !bk.onLoan();
    }

    // MODIFIES: this
    // EFFECTS: if possible, set bk as being on loan from this library;
    //          return true if successful, else false
    public boolean checkOutBook(Book bk) {
        if (inCatalogue(bk) && !bk.onLoan()) {
            bk.nowOnLoan();
            return true; 
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: set bk as being not on loan, if it has been checked out previously;
    //          return true if successful, otherwise false
    public boolean returnBook(Book bk) {
        if(inCatalogue(bk) && bk.onLoan()) {
            bk.notOnLoan();
            return true; 
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: sets this library's librarian
    public void hireLibrarian(Librarian manager) {
        this.manager = manager; 
    }


    // Utility method, do not touch its implementation
    public void printCatalogue() {
        List<Book> totalCatalogue = new LinkedList<>();
        totalCatalogue.addAll(this.cookBooks);
        totalCatalogue.addAll(this.fictionBooks);
        totalCatalogue.addAll(this.nonfictionBooks);
        totalCatalogue.addAll(this.textBooks);
        totalCatalogue.addAll(this.referenceBooks);

        for (Book b : totalCatalogue) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }
    }


}
