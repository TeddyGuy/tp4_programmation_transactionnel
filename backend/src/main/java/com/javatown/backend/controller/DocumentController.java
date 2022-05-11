package com.javatown.backend.controller;

import com.javatown.backend.dto.input.DocumentSearchDto;
import com.javatown.backend.dto.input.document.BookInputDto;
import com.javatown.backend.dto.input.document.CdInputDto;
import com.javatown.backend.dto.input.document.DvdInputDto;
import com.javatown.backend.dto.output.document.DocumentOutputDto;
import com.javatown.backend.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/documents")
@CrossOrigin(origins = "http://localhost:3000")
public class DocumentController {
    DocumentService documentService;

    @GetMapping
    public List<DocumentOutputDto> getAllDocuments(){
        return documentService.getAllDocuments();
    }

    @PostMapping("/search")
    public List<DocumentOutputDto> searchDocumentsByCriteria(@RequestBody DocumentSearchDto dto){
        return documentService.getAllDocumentsByCriteria(dto);
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

    @ResponseStatus(HttpStatus.CREATED)
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

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/cds/{id}")
    public DocumentOutputDto updateCdById(@PathVariable long id, @RequestBody CdInputDto cdInputDto){
        return documentService.updateDocument(id,cdInputDto);
    }

    @GetMapping("/dvds")
    public List<DocumentOutputDto> getAllDvds(){
        return documentService.getAllDvds();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/dvds")
    public DocumentOutputDto newDvd(@RequestBody DvdInputDto dvdInputDto){
        return documentService.saveDocument(dvdInputDto);
    }

    @PatchMapping("/dvds/{id}")
    public DocumentOutputDto updateDvdById(@PathVariable long id, @RequestBody DvdInputDto dvdInputDto){
        return documentService.updateDocument(id, dvdInputDto);
    }
}
