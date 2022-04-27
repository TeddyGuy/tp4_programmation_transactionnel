package com.javatown.backend.service;

import com.javatown.backend.dto.input.document.DocumentInputDto;
import com.javatown.backend.dto.output.document.DocumentOutputDto;
import com.javatown.backend.exception.DocumentAttributeMissingException;
import com.javatown.backend.model.document.Book;
import com.javatown.backend.model.document.Document;
import com.javatown.backend.repository.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public DocumentOutputDto saveDocument (DocumentInputDto inputDto){
        String missingFields = inputDto.getMissingFields();
        if(!missingFields.isEmpty()) throw new DocumentAttributeMissingException(missingFields);
        return documentRepository.save(inputDto.toDocument()).toOutputDto();
    }

    public List<DocumentOutputDto> getAllDocuments(){
        List<Document> documents = documentRepository.findAll();
        List<DocumentOutputDto> documentOutputDtos = new ArrayList<>();

        for (Document document : documents) {
            documentOutputDtos.add(document.toOutputDto());
        }

        return documentOutputDtos;
    }

    public List<DocumentOutputDto> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        List<DocumentOutputDto> bookOutputDtos = new ArrayList<>();

        for (Book book : books) {
            bookOutputDtos.add(book.toOutputDto());
        }

        return bookOutputDtos;
    }
}
