package com.javatown.backend.repository;

import com.javatown.backend.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
