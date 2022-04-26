package com.javatown.backend.repository;

import com.javatown.backend.model.document.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdRepository extends JpaRepository<Dvd,Long> {
}
