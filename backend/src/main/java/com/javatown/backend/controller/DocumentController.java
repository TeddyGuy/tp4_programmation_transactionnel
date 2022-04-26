package com.javatown.backend.controller;

import com.javatown.backend.dto.input.document.BookInputDto;
import com.javatown.backend.dto.input.document.DocumentInputDto;
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

    @PostMapping("/books")
    public DocumentOutputDto newBook(@RequestBody BookInputDto bookInputDto){
        return documentService.saveDocument(bookInputDto);
    }
}
