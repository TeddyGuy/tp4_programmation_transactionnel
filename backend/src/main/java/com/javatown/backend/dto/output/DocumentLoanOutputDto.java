package com.javatown.backend.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentLoanOutputDto {
    private long id;
    private long documentId;
    private long clientId;
    private LocalDate lendingDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;
}
