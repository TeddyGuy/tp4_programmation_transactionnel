package com.javatown.backend.controller;

import com.javatown.backend.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
}
