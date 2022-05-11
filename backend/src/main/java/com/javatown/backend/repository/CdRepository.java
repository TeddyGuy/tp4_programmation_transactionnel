package com.javatown.backend.repository;

import com.javatown.backend.model.document.Cd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdRepository extends JpaRepository<Cd,Long> {

}
