package com.javatown.backend.service;

import com.javatown.backend.dto.input.document.BookInputDto;
import com.javatown.backend.dto.input.document.CdInputDto;
import com.javatown.backend.dto.input.document.DocumentInputDto;
import com.javatown.backend.dto.input.document.DvdInputDto;
import com.javatown.backend.dto.output.document.DocumentOutputDto;
import com.javatown.backend.exception.DocumentNotFoundException;
import com.javatown.backend.exception.DtoFieldsMissingException;
import com.javatown.backend.model.document.Document;
import com.javatown.backend.repository.BookRepository;
import com.javatown.backend.repository.CdRepository;
import com.javatown.backend.repository.DocumentRepository;
import com.javatown.backend.repository.DvdRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DocumentService {

    final private DocumentRepository documentRepository;
    final private BookRepository bookRepository;
    final private CdRepository cdRepository;
    final private DvdRepository dvdRepository;

    public DocumentOutputDto saveDocument (DocumentInputDto inputDto){
        String missingFields = inputDto.getMissingFields();
        if(!missingFields.isEmpty()) throw new DtoFieldsMissingException(missingFields);
        return documentRepository.save(inputDto.toDocument()).toOutputDto();
    }

    public DocumentOutputDto getDocumentById(long id){
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException(id));
        return document.toOutputDto();
    }

    public void deleteDocumentById(long id){
        try{
            documentRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new DocumentNotFoundException(id);
        }
    }

    public List<DocumentOutputDto> getAllDocuments(){
        return Document.toDocumentOutputDtoList(documentRepository.findAll());
    }

    public List<DocumentOutputDto> getAllBooks(){
        return Document.toDocumentOutputDtoList(bookRepository.findAll());
    }

    public List<DocumentOutputDto> getAllCds(){
        return Document.toDocumentOutputDtoList(cdRepository.findAll());
    }

    public List<DocumentOutputDto> getAllDvds(){ return Document.toDocumentOutputDtoList(dvdRepository.findAll());}

    public DocumentOutputDto updateDocument(long id, DocumentInputDto inputDto){
        Document document = null;

        if(inputDto instanceof BookInputDto)
            document = bookRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException("book",id));
        if(inputDto instanceof CdInputDto)
            document = cdRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException("cd", id));
        if(inputDto instanceof DvdInputDto)
            document = dvdRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException("dvd", id));

        if(document == null) throw new DocumentNotFoundException(id);

        document.update(inputDto);

        return documentRepository.save(document).toOutputDto();
    }
}
