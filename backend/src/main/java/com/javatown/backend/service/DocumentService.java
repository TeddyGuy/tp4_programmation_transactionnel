package com.javatown.backend.service;

import com.javatown.backend.repository.*;
import org.springframework.stereotype.Component;

@Component
public class DocumentService {

    private DocumentRepository documentRepository;
    private BookRepository bookRepository;
    private CDRepository cdRepository;
    private DVDRepository dvdRepository;

    public DocumentService(DocumentRepository documentRepository,
                           BookRepository bookRepository,
                           CDRepository cdRepository,
                           DVDRepository dvdRepository) {
        this.documentRepository = documentRepository;
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }
}
