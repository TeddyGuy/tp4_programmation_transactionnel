package com.javatown.backend.repository;

import com.javatown.backend.model.document.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepository extends JpaRepository<DVD,Long> {
}
