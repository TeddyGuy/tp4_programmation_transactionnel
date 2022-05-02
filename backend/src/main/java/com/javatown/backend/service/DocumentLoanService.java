package com.javatown.backend.service;

import com.javatown.backend.dto.input.DocumentLoanInputDto;
import com.javatown.backend.dto.input.DocumentReturnRequestDto;
import com.javatown.backend.dto.output.DocumentLoanOutputDto;
import com.javatown.backend.exception.*;
import com.javatown.backend.model.Client;
import com.javatown.backend.model.DocumentLoan;
import com.javatown.backend.model.document.Document;
import com.javatown.backend.repository.ClientRepository;
import com.javatown.backend.repository.DocumentLoanRepository;
import com.javatown.backend.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class DocumentLoanService {
    final private ClientRepository clientRepository;
    final private DocumentLoanRepository documentLoanRepository;
    final private DocumentRepository documentRepository;

    public DocumentLoanOutputDto borrowDocument(DocumentLoanInputDto inputDto){
        String missingFields = inputDto.getMissingFields();
        if(!missingFields.isEmpty()) throw new DtoFieldsMissingException(missingFields);

        Client client = clientRepository.findByIdWithBorrowingHistory(inputDto.getClientId())
                .orElseThrow(() -> new ClientNotFoundException(inputDto.getClientId()));

        Document document = documentRepository.findById(inputDto.getDocumentId())
                .orElseThrow(() -> new DocumentNotFoundException(inputDto.getDocumentId()));

        if(document.getCopies() < 1) throw new InsufficientAmountOfCopiesException();

        DocumentLoan documentLoan = (inputDto.getLendingDate() == null ?
                new DocumentLoan(document,client) :
                new DocumentLoan(document,client,inputDto.getLendingDate()));

        client.getBorrowingHistory().add(documentLoan);
        document.setCopies(document.getCopies() - 1);

        documentRepository.save(document);
        clientRepository.save(client);

        return documentLoanRepository.save(documentLoan).toOutPutDto();
    }

    public DocumentLoanOutputDto returnDocument(long documentLoanId, DocumentReturnRequestDto inputDto){
        DocumentLoan documentLoan = documentLoanRepository
                .findById(documentLoanId).orElseThrow(() -> new DocumentLoanNotFoundException(documentLoanId));

        if (!(documentLoan.getActualReturnDate() == null)) throw new DocumentAlreadyReturnedException();

        Document document = documentLoan.getDocument();

        if(inputDto == null || inputDto.getReturnDate() == null || inputDto.getReturnDate().isBlank())
            documentLoan.setActualReturnDate(LocalDate.now());
        else
            documentLoan.setActualReturnDate(LocalDate.parse(inputDto.getReturnDate()));

        document.setCopies(document.getCopies() + 1);

        documentRepository.save(document);
        return documentLoanRepository.save(documentLoan).toOutPutDto();
    }
}
