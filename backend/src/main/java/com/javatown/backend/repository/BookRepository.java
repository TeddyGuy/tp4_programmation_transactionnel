package com.javatown.backend.repository;

import com.javatown.backend.model.document.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
