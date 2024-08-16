package org.example.challenge4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.challenge3.Book;

class BookTest {
    @Test
    void testGettersAndSetters() {
        // Create a book object
        Book book = new Book();

        // Set values using setters
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setPublicationYear(2022);
        book.setIsbn("ISBN123");
        book.setPrice(9.99);

        // Verify values using getters
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals(2022, book.getPublicationYear());
        assertEquals("ISBN123", book.getIsbn());
        assertEquals(9.99, book.getPrice(), 0.01);
    }

    @Test
    void testToString() {
        // Create a book object
        Book book = new Book("Title", "Author", 2022, "ISBN123", 9.99);

        // Verify the toString method
        assertEquals("Book{title='Title', author='Author', publicationYear=2022, isbn='ISBN123', price=9.99}",
                book.toString());
    }
}