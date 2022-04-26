package com.javatown.backend.service;

import com.javatown.backend.dto.output.ClientOutputDto;
import com.javatown.backend.dto.input.ClientInputDto;
import com.javatown.backend.exception.ClientAttributesMissingException;
import com.javatown.backend.exception.ClientNotFoundException;
import com.javatown.backend.model.Client;
import com.javatown.backend.repository.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientService {
    private ClientRepository clientRepository;
    private DocumentLoanRepository documentLoanRepository;
    private BookRepository bookRepository;
    private CdRepository cdRepository;
    private DvdRepository dvdRepository;

    public ClientService(ClientRepository clientRepository,
                        DocumentLoanRepository documentLoanRepository,
                        BookRepository bookRepository,
                        CdRepository cdRepository,
                        DvdRepository dvdRepository) {
        this.clientRepository = clientRepository;
        this.documentLoanRepository = documentLoanRepository;
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
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

    public ClientOutputDto updateClientById(long id, ClientInputDto clientInputDto){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()) throw new ClientNotFoundException(id);

        Client client = clientOptional.get();

        client.update(clientInputDto);

        return clientRepository.save(client).toOutputDto();
    }
}
