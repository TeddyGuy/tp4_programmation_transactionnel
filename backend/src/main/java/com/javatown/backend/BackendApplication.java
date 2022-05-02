package com.javatown.backend;

import com.javatown.backend.dto.input.ClientInputDto;
import com.javatown.backend.dto.input.DocumentLoanInputDto;
import com.javatown.backend.dto.input.document.BookInputDto;
import com.javatown.backend.dto.input.document.CdInputDto;
import com.javatown.backend.dto.input.document.DocumentInputDto;
import com.javatown.backend.dto.input.document.DvdInputDto;
import com.javatown.backend.service.ClientService;
import com.javatown.backend.service.DocumentLoanService;
import com.javatown.backend.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@AllArgsConstructor
public class BackendApplication implements CommandLineRunner {
    ClientService clientService;
    DocumentService documentService;
    DocumentLoanService documentLoanService;

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

        DocumentInputDto book1 = new BookInputDto("Le Gardien","Justin Trudeau","Aventure","ME Quebec",2020,234);
        DocumentInputDto book2 = new BookInputDto("Le Destructeur", "Eliotte Trudeau","Action","ME Montreal",2004,198);
        DocumentInputDto book3 = new BookInputDto("Voyage Miraculeux","Maurice Duplessis","Drame","ME Quebec",1993,348);

        DocumentInputDto cd1 = new CdInputDto("Batman","Zack Snyder","Fantaisie",2020);
        DocumentInputDto cd2 = new CdInputDto("Joker","Himself","Dystopie",2017);
        DocumentInputDto cd3 = new CdInputDto("Avengers: Age of Ultron","Marvel","Action",2014);

        DocumentInputDto dvd1 = new DvdInputDto("Pirates of the Caribbeans","Johnny Depp","Aventure",2006);
        DocumentInputDto dvd2 = new DvdInputDto("Dont Look Up!","Leonardo Dicaprio","Dystopie",2022);
        DocumentInputDto dvd3 = new DvdInputDto("Justice League","DC","Action",2019);

        clientService.saveClient(client1);
        clientService.saveClient(client2);
        clientService.saveClient(client3);
        clientService.saveClient(client4);
        clientService.saveClient(client5);

        documentService.saveDocument(book1);
        documentService.saveDocument(book2);
        documentService.saveDocument(book3);

        documentService.saveDocument(cd1);
        documentService.saveDocument(cd2);
        documentService.saveDocument(cd3);

        documentService.saveDocument(dvd1);
        documentService.saveDocument(dvd2);
        documentService.saveDocument(dvd3);

        documentLoanService.borrowDocument(new DocumentLoanInputDto(6,1));
        documentLoanService.borrowDocument(new DocumentLoanInputDto(7, 1));
        documentLoanService.borrowDocument(new DocumentLoanInputDto(12,1));
    }
}
