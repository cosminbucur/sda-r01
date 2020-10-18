package com.sda.spring.boot.rest.dto;

import com.sda.spring.boot.rest.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequest dto) {
        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPublished(dto.getPublished());
        return entity;
    }

    public BookResponse toDto(Book entity) {
        BookResponse dto = new BookResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAuthor(entity.getAuthor());
        dto.setPublished(entity.getPublished());
        return dto;
    }

    public void map(BookRequest dto, Book entity) {
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPublished(dto.getPublished());
    }
}
