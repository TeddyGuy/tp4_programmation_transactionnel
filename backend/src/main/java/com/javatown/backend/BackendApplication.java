package com.javatown.backend;

import com.javatown.backend.dto.input.ClientInputDto;
import com.javatown.backend.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
    ClientService clientService;

    public BackendApplication(ClientService clientService) {
        this.clientService = clientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args){
        ClientInputDto client1 = new ClientInputDto("joe@gmail.com","Joe","Biden");
        ClientInputDto client2 = new ClientInputDto("donald@gmail.com","Donald","Trump");
        ClientInputDto client3 = new ClientInputDto("obama@gmail.com","Obama","Barrack");
        ClientInputDto client4 = new ClientInputDto("abraham@gmail.com","Abraham","Lincoln");
        ClientInputDto client5 = new ClientInputDto("george@gmail.com","George","Bush");
        clientService.saveClient(client1);
        clientService.saveClient(client2);
        clientService.saveClient(client3);
        clientService.saveClient(client4);
        clientService.saveClient(client5);
    }
}
