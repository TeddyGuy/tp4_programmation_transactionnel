package com.javatown.backend.dto;

import com.javatown.backend.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientForm {
    private String email;
    private String firstName;
    private String lastName;

    public Client toClient(){
        return new Client(email,firstName,lastName);
    }
}
