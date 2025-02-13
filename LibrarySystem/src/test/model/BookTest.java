package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.BookType.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book refBook;

    @BeforeEach
    public void setUp() {
        refBook = new Book("Encyclopedia Britannica", "John Williams", REFERENCE, 1850, 1);
    }

    @Test
    public void testConstructor() {
        assertEquals("Encyclopedia Britannica", refBook.getTitle());
        assertEquals("John Williams", refBook.getAuthor());
        assertEquals(REFERENCE, refBook.getType());
        assertEquals(1850, refBook.getYear());
        assertEquals(1, refBook.getEdition());
    }

    @Test
    public void testloanStatus() {
        assertFalse(refBook.onLoan());
        refBook.nowOnLoan();
        assertTrue(refBook.onLoan());
        refBook.notOnLoan();
        assertFalse(refBook.onLoan());
    }
}