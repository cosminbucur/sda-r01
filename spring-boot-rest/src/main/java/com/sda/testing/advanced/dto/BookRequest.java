package com.sda.testing.advanced.dto;

import java.time.LocalDate;

// DTO used to create books from external source
public class BookRequest {

    private String title;
    private String author;
    private LocalDate published;

    public BookRequest() {
    }

    public BookRequest(String title, String author, LocalDate published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "CreateBookRequest{" +
            "title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", published=" + published +
            '}';
    }
}
