package com.sda.testing.advanced.repository;

import com.sda.testing.advanced.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// deals with entities, not with DTOs
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    // derived query
    List<Book> findByAuthor(String author);

    // query - HQL
    @Query("FROM Book b WHERE b.author=:author")
    List<Book> findByAuthorQuery(String author);
}
