package com.javatown.backend.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentSearchDto {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
}
