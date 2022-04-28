package com.javatown.backend.controller;

import com.javatown.backend.dto.input.document.BookInputDto;
import com.javatown.backend.dto.input.document.CdInputDto;
import com.javatown.backend.dto.output.document.DocumentOutputDto;
import com.javatown.backend.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<DocumentOutputDto> getAllDocuments(){
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public DocumentOutputDto getDocumentById(@PathVariable long id){
        return documentService.getDocumentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable long id){
        documentService.deleteDocumentById(id);
    }

    @GetMapping("/books")
    public List<DocumentOutputDto> getAllBooks(){
        return documentService.getAllBooks();
    }

    @PostMapping("/books")
    public DocumentOutputDto newBook(@RequestBody BookInputDto bookInputDto){
        return documentService.saveDocument(bookInputDto);
    }

    @PatchMapping("/books/{id}")
    public DocumentOutputDto updateBookById(@PathVariable long id, @RequestBody BookInputDto bookInputDto){
        return documentService.updateDocument(id,bookInputDto);
    }

    @GetMapping("/cds")
    public List<DocumentOutputDto> getAllCds(){
        return documentService.getAllCds();
    }

    @PostMapping("/cds")
    public DocumentOutputDto newCd(@RequestBody CdInputDto cdInputDto){
        return documentService.saveDocument(cdInputDto);
    }
}
