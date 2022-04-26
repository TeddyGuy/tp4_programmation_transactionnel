package com.javatown.backend.model;

import com.javatown.backend.dto.ClientDTO;
import com.javatown.backend.dto.ClientForm;
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

    public ClientDTO toDTO(){
        return new ClientDTO(id,email,firstName,lastName);
    }

    public void update(ClientForm form){
        if(!(form.getEmail() == null || form.getEmail().isBlank())) this.email = form.getEmail();
        if(!(form.getFirstName() == null || form.getFirstName().isBlank())) this.firstName = form.getFirstName();
        if(!(form.getLastName() == null || form.getLastName().isBlank())) this.lastName = form.getLastName();
    }
}