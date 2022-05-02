package com.javatown.backend.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentLoanInputDto {
    private long documentId;
    private long clientId;
    private LocalDate lendingDate;

    public DocumentLoanInputDto (long documentId, long clientId){
        this.documentId = documentId;
        this.clientId = clientId;
    }
}
