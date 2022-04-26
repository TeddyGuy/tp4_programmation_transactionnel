package com.javatown.backend.controller;

import com.javatown.backend.dto.ClientDTO;
import com.javatown.backend.dto.ClientForm;
import com.javatown.backend.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDTO postClients(@RequestBody ClientForm clientForm) {
        return clientService.saveClient(clientForm);
    }

    @GetMapping
    public List<ClientDTO> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        clientService.deleteClientById(id);
    }
}

