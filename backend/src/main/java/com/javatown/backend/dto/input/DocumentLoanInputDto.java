package com.javatown.backend.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DocumentLoanInputDto {
    private long documentId;
    private LocalDate lendingDate;

    public DocumentLoanInputDto (long documentId){
        this.documentId = documentId;
    }
}
