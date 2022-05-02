package com.javatown.backend.controller;

import com.javatown.backend.dto.input.ClientInputDto;
import com.javatown.backend.dto.output.ClientOutputDto;
import com.javatown.backend.dto.output.DocumentLoanOutputDto;
import com.javatown.backend.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {
    ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClientOutputDto newClients(@RequestBody ClientInputDto clientInputDto) {
        return clientService.saveClient(clientInputDto);
    }

    @GetMapping
    public List<ClientOutputDto> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientOutputDto getClientById(@PathVariable long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        clientService.deleteClientById(id);
    }

    @PatchMapping("/{id}")
    public ClientOutputDto updateClient(@PathVariable long id, @RequestBody ClientInputDto inputDto){
        return clientService.updateClientById(id, inputDto);
    }

    @GetMapping("/{id}/borrowing-history")
    public List<DocumentLoanOutputDto> getBorrowingHistory(@PathVariable long id){
        return clientService.getBorrowingHistory(id);
    }
}

