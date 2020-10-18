package com.sda.spring.boot.rest.service;

import com.sda.spring.boot.rest.dto.BookMapper;
import com.sda.spring.boot.rest.dto.BookResponse;
import com.sda.spring.boot.rest.dto.BookRequest;
import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// deals with DTOs, not with entities
@Service
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    // save
    public BookResponse save(BookRequest bookRequest) {
        // convert dto to entity
        Book book = bookMapper.toEntity(bookRequest);

        Book savedBook = bookRepository.save(book);

        // convert entity to dto
        BookResponse bookResponse = bookMapper.toDto(savedBook);

        return bookResponse;
    }

    // find all
    public List<BookResponse> findAll() {
        List<Book> books = bookRepository.findAll();

        // convert each book to a response
        return books.stream()
            .map(book -> bookMapper.toDto(book))
            .collect(Collectors.toList());
    }

    // find by id
    public BookResponse findById(long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("book not found"));

        return bookMapper.toDto(book);
    }

    // find by author
    public List<BookResponse> findByAuthor(String author) {
        // TODO: var1: implement method in repository

        // var2: find all and filter
        return bookRepository.findAll()                      // List<Book>
            .stream()                                        // Stream<Book>
            .filter(book -> book.getAuthor().equals(author)) // Stream<Book>
            .map(book -> bookMapper.toDto(book))             // Stream<BookResponse>
            .collect(Collectors.toList());                   // List<BookResponse>
    }

    // update
    public void update(BookRequest bookRequest, long id) {
        Book bookToUpdate = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("book not found"));

        // update book details
        bookMapper.map(bookRequest, bookToUpdate);

        bookRepository.save(bookToUpdate);
    }

    // delete
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
}
