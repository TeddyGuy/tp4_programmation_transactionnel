package com.javatown.backend.repository;

import com.javatown.backend.model.document.CD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CDRepository extends JpaRepository<CD,Long> {
}
