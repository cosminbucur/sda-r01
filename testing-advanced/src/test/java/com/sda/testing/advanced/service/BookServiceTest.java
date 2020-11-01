package com.sda.testing.advanced.service;

import com.sda.testing.advanced.dto.BookMapper;
import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import com.sda.testing.advanced.model.Book;
import com.sda.testing.advanced.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Mock
    BookMapper bookMapper;

    @InjectMocks
    BookService bookService;

    // functional test
    // unit test
    // if has dependencies > use mocks
    @Test
    void givenBookRequest_whenSave_thenReturnBookResponse() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("game of thrones");
        request.setAuthor("george martin");
        request.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook = new Book();
        mockBook.setTitle("game of thrones");
        mockBook.setAuthor("george martin");
        mockBook.setPublished(LocalDate.of(2000, 6, 30));

        when(bookMapper.toEntity(any(BookRequest.class)))
            .thenReturn(mockBook);
        when(bookRepository.save(any(Book.class)))
            .thenReturn(mockBook);
        when(bookMapper.toDto(any(Book.class)))
            .thenReturn(expected);

        // when
        BookResponse actual = bookService.save(request);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenExistingBook_whenSave_thenThrowException() {
        // given
        String sameTitle = "game of thrones";

        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle(sameTitle);
        bookRequest.setAuthor("george martin");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook = new Book();
        mockBook.setTitle(sameTitle);

        when(bookRepository.findByTitle(anyString()))
            .thenReturn(Optional.of(mockBook));

        // then
        // check that exception is thrown
        Assertions.assertThrows(RuntimeException.class,
            // when
            () -> bookService.save(bookRequest));
    }
}
