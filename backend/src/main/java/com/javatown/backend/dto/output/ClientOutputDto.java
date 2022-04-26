package com.javatown.backend.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientOutputDto {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
}
