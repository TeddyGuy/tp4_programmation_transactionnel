package com.javatown.backend.service;

import com.javatown.backend.dto.ClientDTO;
import com.javatown.backend.dto.ClientForm;
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
    private CDRepository cdRepository;
    private DVDRepository dvdRepository;

    public ClientService(ClientRepository clientRepository,
                        DocumentLoanRepository documentLoanRepository,
                        BookRepository bookRepository,
                        CDRepository cdRepository,
                        DVDRepository dvdRepository) {
        this.clientRepository = clientRepository;
        this.documentLoanRepository = documentLoanRepository;
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();

        for (Client client: clients) {
            clientDTOS.add(client.toDTO());
        }

        return clientDTOS;
    }

    public ClientDTO saveClient(ClientForm form){
        String missingFields = getMissingFields(form);
        if (!missingFields.isEmpty()) throw new ClientAttributesMissingException(missingFields);
        return clientRepository.save(form.toClient()).toDTO();
    }

    public ClientDTO getClientById(long id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()) throw new ClientNotFoundException(id);
        return clientOptional.get().toDTO();
    }

    public void deleteClientById(long id){
        try{
            clientRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ClientNotFoundException(id);
        }
    }

    private String getMissingFields(ClientForm form){
        String missingFields = "";

        if(form.getEmail() == null || form.getEmail().isBlank()) missingFields += "email, ";
        if(form.getFirstName() == null || form.getFirstName().isBlank()) missingFields += "firstName, ";
        if(form.getLastName() == null || form.getLastName().isBlank()) missingFields += "lastName";

        return missingFields;
    }
}
