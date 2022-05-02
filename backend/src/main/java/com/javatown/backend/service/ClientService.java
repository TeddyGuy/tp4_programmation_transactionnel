package com.javatown.backend.service;

import com.javatown.backend.dto.input.DocumentLoanInputDto;
import com.javatown.backend.dto.output.ClientOutputDto;
import com.javatown.backend.dto.input.ClientInputDto;
import com.javatown.backend.dto.output.DocumentLoanOutputDto;
import com.javatown.backend.exception.ClientAttributesMissingException;
import com.javatown.backend.exception.ClientNotFoundException;
import com.javatown.backend.exception.InsufficientAmountOfCopiesException;
import com.javatown.backend.model.Client;
import com.javatown.backend.model.DocumentLoan;
import com.javatown.backend.model.document.Document;
import com.javatown.backend.repository.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientService {
    final private ClientRepository clientRepository;
    final private DocumentLoanRepository documentLoanRepository;
    final private DocumentRepository documentRepository;

    public ClientService(ClientRepository clientRepository,
                        DocumentLoanRepository documentLoanRepository,
                        DocumentRepository documentRepository) {
        this.clientRepository = clientRepository;
        this.documentLoanRepository = documentLoanRepository;
        this.documentRepository = documentRepository;
    }

    public List<ClientOutputDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientOutputDto> clientOutputDtos = new ArrayList<>();

        for (Client client: clients) {
            clientOutputDtos.add(client.toOutputDto());
        }

        return clientOutputDtos;
    }

    public ClientOutputDto saveClient(ClientInputDto clientInputDto){
        String missingFields = clientInputDto.getMissingFields();
        if (!missingFields.isEmpty()) throw new ClientAttributesMissingException(missingFields);
        return clientRepository.save(clientInputDto.toClient()).toOutputDto();
    }

    public ClientOutputDto getClientById(long id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()) throw new ClientNotFoundException(id);
        return clientOptional.get().toOutputDto();
    }

    public void deleteClientById(long id){
        try{
            clientRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ClientNotFoundException(id);
        }
    }

    public DocumentLoanOutputDto borrowDocument(long id, DocumentLoanInputDto inputDto){
        Client client = clientRepository.findByIdWithBorrowingHistory(id).orElseThrow(() -> new ClientNotFoundException(id));
        Document document = documentRepository.findById(inputDto.getDocumentId()).orElseThrow(() -> new ClientNotFoundException(id));

        if(document.getCopies() < 1) throw new InsufficientAmountOfCopiesException();

        DocumentLoan documentLoan = (inputDto.getLendingDate() == null ? new DocumentLoan(document,client) : new DocumentLoan(document,client,inputDto.getLendingDate()));

        client.getBorrowingHistory().add(documentLoan);
        document.setCopies(document.getCopies() - 1);

        documentRepository.save(document);
        clientRepository.save(client);

        return documentLoanRepository.save(documentLoan).toOutPutDto();
    }

    public ClientOutputDto updateClientById(long id, ClientInputDto clientInputDto){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()) throw new ClientNotFoundException(id);

        Client client = clientOptional.get();

        client.update(clientInputDto);

        return clientRepository.save(client).toOutputDto();
    }

    public List<DocumentLoanOutputDto> getBorrowingHistory(long id) {
        List<DocumentLoan> documentLoans = documentLoanRepository.getDocumentLoansByClient_Id(id);
        List<DocumentLoanOutputDto> outputDtos = new ArrayList<>();

        for (DocumentLoan documentLoan : documentLoans){
            outputDtos.add(documentLoan.toOutPutDto());
        }

        return outputDtos;
    }
}
