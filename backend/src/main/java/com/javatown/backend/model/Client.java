package com.javatown.backend.model;

import com.javatown.backend.dto.input.ClientInputDto;
import com.javatown.backend.dto.output.ClientOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "client")
    private List<DocumentLoan> borrowingHistory = new ArrayList();

    public Client(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ClientOutputDto toOutputDto(){
        return new ClientOutputDto(id,email,firstName,lastName);
    }

    public void update(ClientInputDto inputDto){
        if(!(inputDto.getEmail() == null || inputDto.getEmail().isBlank())) this.email = inputDto.getEmail();
        if(!(inputDto.getFirstName() == null || inputDto.getFirstName().isBlank())) this.firstName = inputDto.getFirstName();
        if(!(inputDto.getLastName() == null || inputDto.getLastName().isBlank())) this.lastName = inputDto.getLastName();
    }
}