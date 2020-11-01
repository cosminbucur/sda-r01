package com.sda.testing.advanced.dto;

import com.sda.testing.advanced.model.Book;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookMapperTest {

    @Test
    void toEntity() {
    }

    @Test
    void testToEntity() {
    }

    // functional test
    // unit test
    // if not dependencies > no mocking needed
    @Test
    void givenBook_whenToDto_thenReturnBookResponse() {
        // given
        BookMapper bookMapper = new BookMapper();
        Book book = new Book();
        book.setAuthor("author1");
        book.setTitle("title1");

        BookResponse expectedResponse = new BookResponse();
        expectedResponse.setAuthor("author1");
        expectedResponse.setTitle("title1");

        // when
        BookResponse actualResponse = bookMapper.toDto(book);

        // then
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}