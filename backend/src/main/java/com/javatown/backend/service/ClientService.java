package com.javatown.backend.service;

import com.javatown.backend.dto.input.ClientInputDto;
import com.javatown.backend.dto.output.ClientOutputDto;
import com.javatown.backend.dto.output.DocumentLoanOutputDto;
import com.javatown.backend.exception.DtoFieldsMissingException;
import com.javatown.backend.exception.ClientNotFoundException;
import com.javatown.backend.model.Client;
import com.javatown.backend.model.DocumentLoan;
import com.javatown.backend.repository.ClientRepository;
import com.javatown.backend.repository.DocumentLoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ClientService {
    final private ClientRepository clientRepository;
    final private DocumentLoanRepository documentLoanRepository;

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
        if (!missingFields.isEmpty()) throw new DtoFieldsMissingException(missingFields);
        return clientRepository.save(clientInputDto.toClient()).toOutputDto();
    }

    public ClientOutputDto getClientById(long id){
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        return client.toOutputDto();
    }

    public void deleteClientById(long id){
        try{
            clientRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ClientNotFoundException(id);
        }
    }

    public ClientOutputDto updateClientById(long id, ClientInputDto clientInputDto){
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));

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
