package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.BookType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianTest {
    private Book ficBook;
    private Librarian testLibrarian;

    @BeforeEach
    public void setUp() {
        ficBook = new Book("Harry Potter and the Deathy Hallows", "J.K. Rowling", FICTION, 2007, 1);
        testLibrarian = new Librarian("Alan Kay", 11, ficBook);
    }

    @Test
    public void testConstructor() {
        assertEquals("Alan Kay", testLibrarian.getName());
        assertEquals(11, testLibrarian.getAge());
        assertEquals(ficBook, testLibrarian.getFavBook());
    }
}