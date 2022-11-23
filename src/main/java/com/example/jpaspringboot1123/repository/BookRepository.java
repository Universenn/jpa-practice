package com.example.jpaspringboot1123.repository;

import com.example.jpaspringboot1123.domain.entity.Author;
import com.example.jpaspringboot1123.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
