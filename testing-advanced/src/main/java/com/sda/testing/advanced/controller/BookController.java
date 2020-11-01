package com.sda.testing.advanced.controller;

import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import com.sda.testing.advanced.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping    // 301 = CREATED
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(bookService.save(bookRequest));
    }

    @GetMapping // 200 = OK
    public ResponseEntity<List<BookResponse>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    // on error 404 = NOT FOUND
    // http://localhost:8081/api/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    // http://localhost:8081/api/books/<author>
    @GetMapping("/{author}")
    public ResponseEntity<List<BookResponse>> findByAuthor(
        @PathVariable(name = "author") String author) {

        return ResponseEntity.ok(bookService.findByAuthor(author));
    }

    // update book
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(
        @PathVariable("id") Long id,
        @RequestBody BookRequest bookRequest) {

        return ResponseEntity.ok(bookService.update(id, bookRequest));
    }

    // http://localhost:8081/api/books/{id}
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
    }
}
