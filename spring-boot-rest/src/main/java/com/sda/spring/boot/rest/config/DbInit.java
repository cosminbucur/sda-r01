package com.sda.spring.boot.rest.config;

import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DbInit implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DbInit.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) {
        createBooks();
    }

    private void createBooks() {
        Book book = new Book("Title", "Author", LocalDate.of(2020, 10, 18));
        bookRepository.save(book);
        List<Book> foundBooks = bookRepository.findAll();
        foundBooks.forEach(b -> log.info("Book {} was saved", b));
    }
}
