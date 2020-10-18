package com.sda.spring.boot.rest.controller;

import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sda.spring.boot.rest.controller.BookController.API_BOOKS;

@RestController
@RequestMapping(API_BOOKS)
public class BookController {

    public static final String API_BOOKS = "/api/books";
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void createBook(@RequestBody BookRequest bookRequest) {
        bookService.save(bookRequest);
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.findAll();
    }

    // TODO: getBookByAuthor

    // http://localhost:8081/api/books/{id}
    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    // update book
    @PutMapping("/{id}")
    public void updateBook(
        @RequestBody BookRequest bookRequest,
        @PathVariable("id") Long id) {

        bookService.update(bookRequest, id);
    }

    // http://localhost:8081/api/books/{id}
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
    }
}
