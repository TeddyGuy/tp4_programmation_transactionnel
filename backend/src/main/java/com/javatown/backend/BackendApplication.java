package com.javatown.backend;

import com.javatown.backend.dto.ClientForm;
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
        ClientForm client1 = new ClientForm("joe@gmail.com","Joe","Biden");
        ClientForm client2 = new ClientForm("donald@gmail.com","Donald","Trump");
        ClientForm client3 = new ClientForm("obama@gmail.com","Obama","Barrack");
        ClientForm client4 = new ClientForm("abraham@gmail.com","Abraham","Lincoln");
        ClientForm client5 = new ClientForm("george@gmail.com","George","Bush");
        clientService.saveClient(client1);
        clientService.saveClient(client2);
        clientService.saveClient(client3);
        clientService.saveClient(client4);
        clientService.saveClient(client5);
    }
}
