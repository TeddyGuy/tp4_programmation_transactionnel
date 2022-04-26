package com.javatown.backend.service;

import com.javatown.backend.repository.*;
import org.springframework.stereotype.Component;

@Component
public class DocumentService {

    private BookRepository bookRepository;
    private CDRepository cdRepository;
    private DVDRepository dvdRepository;

    public DocumentService(BookRepository bookRepository,
                           CDRepository cdRepository,
                           DVDRepository dvdRepository) {
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }
}
