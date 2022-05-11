package com.javatown.backend.controller;

import com.javatown.backend.dto.input.DocumentLoanInputDto;
import com.javatown.backend.dto.input.DocumentReturnRequestDto;
import com.javatown.backend.dto.output.DocumentLoanOutputDto;
import com.javatown.backend.service.DocumentLoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/document-loans")
@CrossOrigin(origins = "http://localhost:3000")
public class DocumentLoansController {
    DocumentLoanService documentLoanService;

    @GetMapping
    public List<DocumentLoanOutputDto> getDocumentLoans(){
        return documentLoanService.getAllDocumentLoans();
    }

    @GetMapping("/{id}")
    public DocumentLoanOutputDto getDocumentLoanById(@PathVariable long id){
        return documentLoanService.getDocumentLoanById(id);
    }

    @PostMapping
    public DocumentLoanOutputDto borrowDocument(@RequestBody DocumentLoanInputDto inputDto){
        return documentLoanService.borrowDocument(inputDto);
    }

    @PostMapping("/{id}/return")
    public DocumentLoanOutputDto returnDocumentWithRequestBody(@PathVariable long id, @RequestBody(required = false) DocumentReturnRequestDto inputDto){
        return documentLoanService.returnDocument(id, inputDto);
    }
}
