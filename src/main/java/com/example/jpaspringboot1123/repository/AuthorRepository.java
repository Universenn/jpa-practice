package com.example.jpaspringboot1123.repository;

import com.example.jpaspringboot1123.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
