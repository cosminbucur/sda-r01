package com.sda.testing.advanced.service;

import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookServiceIntegrationTest {

    @Autowired
    BookService bookService;

    @Test
    void givenBookRequest_whenSave_thenReturnBookResponse() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("game of thrones");
        request.setAuthor("george martin");
        request.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        // when
        BookResponse actual = bookService.save(request);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
