package com.bookmanager;

import com.bookmanager.buisness.dtos.AuthorDTO;
import com.bookmanager.buisness.dtos.BookDTO;
import com.bookmanager.buisness.services.AuthorService;
import com.bookmanager.buisness.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookManagerApplicationTests {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Test
    void createAuthorAndCheckId() {
        AuthorDTO dto = new AuthorDTO();
        dto.setName("Νίκος Καζαντζάκης");
        dto.setNationality("Greek");
        dto.setBirth_date(LocalDate.of(1883, 2, 18));

        Long id = authorService.createAuthor(dto);

        assertNotNull(id);
        assertTrue(id > 0);
    }

    @Test
    void createAuthorAndFindById() {
        AuthorDTO dto = new AuthorDTO();
        dto.setName("Οδυσσέας Ελύτης");
        dto.setNationality("Greek");
        dto.setBirth_date(LocalDate.of(1911, 11, 2));

        Long id = authorService.createAuthor(dto);
        AuthorDTO found = authorService.getAuthorById(id);

        assertNotNull(found);
        assertEquals("Οδυσσέας Ελύτης", found.getName());
        assertEquals("Greek", found.getNationality());
    }

    @Test
    void updateAuthorAndCheck() {
        AuthorDTO dto = new AuthorDTO();
        dto.setName("Παλιό Όνομα");
        dto.setNationality("Greek");
        dto.setBirth_date(LocalDate.of(1900, 1, 1));

        Long id = authorService.createAuthor(dto);

        dto.setId(id);
        dto.setName("Νέο Όνομα");
        authorService.updateAuthor(dto);

        AuthorDTO updated = authorService.getAuthorById(id);
        assertEquals("Νέο Όνομα", updated.getName());
    }

    @Test
    void deleteAuthorAndCheck() {
        AuthorDTO dto = new AuthorDTO();
        dto.setName("Προς Διαγραφή");
        dto.setNationality("Greek");
        dto.setBirth_date(LocalDate.of(1900, 1, 1));

        Long id = authorService.createAuthor(dto);
        authorService.deleteAuthor(id);

        assertThrows(EntityNotFoundException.class, () -> {
            authorService.getAuthorById(id);
        });
    }

    @Test
    void getAllAuthorsNotEmpty() {
        AuthorDTO dto = new AuthorDTO();
        dto.setName("Κάποιος Συγγραφέας");
        dto.setNationality("Greek");
        dto.setBirth_date(LocalDate.of(1950, 5, 10));

        authorService.createAuthor(dto);

        List<AuthorDTO> authors = authorService.getallAuthors();
        assertFalse(authors.isEmpty());
    }

    @Test
    void createBookAndCheckId() {
        BookDTO dto = new BookDTO();
        dto.setTitle("Ο Καπετάν Μιχάλης");
        dto.setIsbn("978-0-00-001111-1");
        dto.setCategory("Fiction");
        dto.setPublication_year(1950);

        Long id = bookService.createBook(dto);

        assertNotNull(id);
        assertTrue(id > 0);
    }

    @Test
    void createBookAndFindById() {
        BookDTO dto = new BookDTO();
        dto.setTitle("Ζορμπάς");
        dto.setIsbn("978-0-00-002222-2");
        dto.setCategory("Fiction");
        dto.setPublication_year(1946);

        Long id = bookService.createBook(dto);
        BookDTO found = bookService.getBookById(id);

        assertNotNull(found);
        assertEquals("Ζορμπάς", found.getTitle());
        assertEquals("Fiction", found.getCategory());
    }

    @Test
    void updateBookAndCheck() {
        BookDTO dto = new BookDTO();
        dto.setTitle("Παλιός Τίτλος");
        dto.setIsbn("978-0-00-003333-3");
        dto.setCategory("Fiction");
        dto.setPublication_year(2000);

        Long id = bookService.createBook(dto);

        dto.setId(id);
        dto.setTitle("Νέος Τίτλος");
        bookService.updateBook(dto);

        BookDTO updated = bookService.getBookById(id);
        assertEquals("Νέος Τίτλος", updated.getTitle());
    }

    @Test
    void deleteBookAndCheck() {
        BookDTO dto = new BookDTO();
        dto.setTitle("Προς Διαγραφή");
        dto.setIsbn("978-0-00-004444-4");
        dto.setCategory("Fiction");
        dto.setPublication_year(2000);

        Long id = bookService.createBook(dto);
        bookService.deleteBook(id);

        assertThrows(EntityNotFoundException.class, () -> {
            bookService.getBookById(id);
        });
    }
}