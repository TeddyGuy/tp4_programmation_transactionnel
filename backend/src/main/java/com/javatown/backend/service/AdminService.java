package com.javatown.backend.service;

import com.javatown.backend.repository.*;
import org.springframework.stereotype.Component;

@Component
public class AdminService {
    private ClientRepository clientRepository;
    private DocumentLoanRepository documentLoanRepository;
    private BookRepository bookRepository;
    private CDRepository cdRepository;
    private DVDRepository dvdRepository;

    public AdminService(ClientRepository clientRepository,
                        DocumentLoanRepository documentLoanRepository,
                        BookRepository bookRepository,
                        CDRepository cdRepository,
                        DVDRepository dvdRepository) {
        this.clientRepository = clientRepository;
        this.documentLoanRepository = documentLoanRepository;
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }
}
