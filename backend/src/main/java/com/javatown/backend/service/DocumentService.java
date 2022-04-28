package com.javatown.backend.service;

import com.javatown.backend.dto.input.document.DocumentInputDto;
import com.javatown.backend.dto.output.document.DocumentOutputDto;
import com.javatown.backend.exception.DocumentAttributeMissingException;
import com.javatown.backend.exception.DocumentNotFoundException;
import com.javatown.backend.model.document.Document;
import com.javatown.backend.repository.*;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

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

    public DocumentOutputDto getDocumentById(long id){
        Optional<Document> documentOptional = documentRepository.findById(id);
        if(documentOptional.isEmpty()) throw new DocumentNotFoundException(id);
        return documentOptional.get().toOutputDto();
    }

    public List<DocumentOutputDto> getAllDocuments(){
        return Document.toDocumentOutputDtoList(documentRepository.findAll());
    }

    public List<DocumentOutputDto> getAllBooks(){
        return Document.toDocumentOutputDtoList(bookRepository.findAll());
    }

    public DocumentOutputDto updateDocument(long id, DocumentInputDto documentInputDto){
        Optional<Document> documentOptional = documentRepository.findById(id);
        if(documentOptional.isEmpty()) throw new DocumentNotFoundException(id);

        Document document = documentOptional.get();

        document.update(documentInputDto);

        return documentRepository.save(document).toOutputDto();
    }
}
