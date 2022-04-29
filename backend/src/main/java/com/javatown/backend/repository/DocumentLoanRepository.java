package com.javatown.backend.repository;

import com.javatown.backend.model.DocumentLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentLoanRepository extends JpaRepository<DocumentLoan, Long> {
    List<DocumentLoan> getDocumentLoansByClient_Id(long client_id);
}
