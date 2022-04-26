package com.javatown.backend.service;

import com.javatown.backend.repository.*;
import org.springframework.stereotype.Component;

@Component
public class DocumentService {

    private DocumentRepository documentRepository;
    private BookRepository bookRepository;
    private CdRepository cdRepository;
    private DvdRepository dvdRepository;

    public DocumentService(DocumentRepository documentRepository,
                           BookRepository bookRepository,
                           CdRepository cdRepository,
                           DvdRepository dvdRepository) {
        this.documentRepository = documentRepository;
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }
}
