package com.javatown.backend.repository;

import com.javatown.backend.model.DocumentLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentLoanRepository extends JpaRepository<DocumentLoan, Long> {
}
