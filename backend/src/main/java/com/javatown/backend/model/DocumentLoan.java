package com.javatown.backend.model;

import com.javatown.backend.model.document.Book;
import com.javatown.backend.model.document.Cd;
import com.javatown.backend.model.document.Dvd;
import com.javatown.backend.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor

public class DocumentLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @ToString.Exclude
    private Document document;

    private LocalDate lendingDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;

    public DocumentLoan(Document document, Client client) {
        this.document = document;
        this.client = client;
        this.lendingDate = LocalDate.now();
        this.expectedReturnDate = this.lendingDate.plusWeeks(document.getBorrowTimeInWeeks());
    }
}
