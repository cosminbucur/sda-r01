package com.sda.testing.advanced.repository;

import com.sda.testing.advanced.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testCrud() {

        // create
        Book book = new Book("Test", "Author", LocalDate.of(2020, 10, 18));
        bookRepository.save(book);

        // read
        Book foundBook = bookRepository.findByTitle(book.getTitle())
            .orElseThrow(() -> new RuntimeException());

        // update
        foundBook.setTitle("Updated");
        bookRepository.save(foundBook);
        Book updatedBook = bookRepository.findByTitle(foundBook.getTitle())
            .orElseThrow(() -> new RuntimeException());
        assertThat(updatedBook.getTitle()).isEqualTo("Updated");

        //delete
        int beforeCount = bookRepository.findAll().size();
        bookRepository.delete(updatedBook);
        int afterCount = bookRepository.findAll().size();
        assertThat(beforeCount > afterCount);
    }

}