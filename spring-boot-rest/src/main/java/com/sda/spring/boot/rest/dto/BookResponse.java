package com.sda.spring.boot.rest.dto;

import java.time.LocalDate;

public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private LocalDate published;

    public BookResponse() {
    }

    public BookResponse(Long id, String title, String author, LocalDate published) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "BookResponse{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", published=" + published +
            '}';
    }
}
