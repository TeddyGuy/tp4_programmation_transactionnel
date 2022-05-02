package com.javatown.backend.controller;

import com.javatown.backend.dto.input.DocumentLoanInputDto;
import com.javatown.backend.dto.input.DocumentReturnRequestDto;
import com.javatown.backend.dto.output.DocumentLoanOutputDto;
import com.javatown.backend.service.DocumentLoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/document-loans")
public class DocumentLoansController {
    DocumentLoanService documentLoanService;

    @PostMapping
    public DocumentLoanOutputDto borrowDocument(@RequestBody DocumentLoanInputDto inputDto){
        return documentLoanService.borrowDocument(inputDto);
    }

    @PostMapping("/{id}/return")
    public DocumentLoanOutputDto returnDocumentWithRequestBody(@PathVariable long id, @RequestBody(required = false) DocumentReturnRequestDto inputDto){
        return documentLoanService.returnDocument(id, inputDto);
    }
}
