package com.example.jpaspringboot1123.service;

import com.example.jpaspringboot1123.domain.dto.BookResponse;
import com.example.jpaspringboot1123.domain.entity.Author;
import com.example.jpaspringboot1123.domain.entity.Book;
import com.example.jpaspringboot1123.repository.AuthorRepository;
import com.example.jpaspringboot1123.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // pageable 은 한 화면에 리미트를 건다.
    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses = books.stream()
                .map(book -> {
                    Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());
                    return BookResponse.of(book,optionalAuthor.get().getName());
                }).collect(Collectors.toList());
        return bookResponses;
    }
}
