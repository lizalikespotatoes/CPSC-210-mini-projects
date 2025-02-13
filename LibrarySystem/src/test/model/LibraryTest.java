package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.BookType.*;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Book refBook;
    private Book ficBook;
    private Book textBook;
    private Book cookBook;
    private Library testLib;
    private Librarian testLibrarian;

    @BeforeEach
    public void setUp() {
        testLibrarian = new Librarian("Alan Kay", 11, ficBook);
        testLib = new Library("Vancouver Public Library", testLibrarian);

        refBook = new Book("Encyclopedia Britannica", "John Williams", REFERENCE, 1850, 1);
        ficBook = new Book("Harry Potter and the Deathy Hallows", "J.K. Rowling", FICTION, 2007, 1);
        textBook = new Book("Introduction to Algorithms", "Thomas H. Cormen", TEXTBOOK, 1992, 1);
        cookBook = new Book("Mastering the Art of French Cooking", "Julia Child", COOKING, 1960, 1);

        testLib.storeBook(refBook);
        testLib.storeBook(ficBook);
        testLib.storeBook(textBook);
        testLib.storeBook(cookBook);
    }

    @Test
    public void testConstructor() {
        assertEquals(testLib.getName(), "Vancouver Public Library");
        assertEquals(testLibrarian, testLib.getManager());
    }

    @Test
    public void testHireLibrarian() {
        Librarian newLibrarian = new Librarian("Maggie Li", 21, refBook);
        testLib.hireLibrarian(newLibrarian);
        assertEquals(newLibrarian, testLib.getManager());
    }

    @Test
    public void testinCatalogue() {
        assertTrue(testLib.inCatalogue(refBook));
        assertTrue(testLib.inCatalogue(cookBook));
        assertTrue(testLib.inCatalogue(ficBook));
        assertTrue(testLib.inCatalogue(textBook));
    }

    @Test
    public void testcanLoan() {
        assertTrue(testLib.canLoan(refBook));
        assertTrue(testLib.checkOutBook(refBook));
        assertFalse(testLib.canLoan(refBook));
        assertFalse(testLib.checkOutBook(refBook));

        assertTrue(testLib.canLoan(cookBook));
        assertTrue(testLib.checkOutBook(cookBook));
        assertFalse(testLib.canLoan(cookBook));
        assertFalse(testLib.checkOutBook(cookBook));
    }

    @Test
    public void testreturnBook() {
        assertTrue(testLib.canLoan(textBook));
        assertTrue(testLib.checkOutBook(textBook));
        assertFalse(testLib.canLoan(textBook));
        assertTrue(testLib.returnBook(textBook));
        assertFalse(testLib.returnBook(textBook));
        assertTrue(testLib.canLoan(textBook));
    }


}