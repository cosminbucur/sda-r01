package com.sda.testing.advanced.dto;

import com.sda.testing.advanced.model.Book;
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

    public Book toEntity(Book bookToUpdate, BookRequest updateRequest) {
        bookToUpdate.setTitle(updateRequest.getTitle());
        bookToUpdate.setAuthor(updateRequest.getAuthor());
        bookToUpdate.setPublished(updateRequest.getPublished());
        return bookToUpdate;
    }

    public BookResponse toDto(Book entity) {
        BookResponse dto = new BookResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAuthor(entity.getAuthor());
        dto.setPublished(entity.getPublished());
        return dto;
    }
}
