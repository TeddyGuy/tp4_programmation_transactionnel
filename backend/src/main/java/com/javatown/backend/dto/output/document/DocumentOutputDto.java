package com.javatown.backend.dto.output.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DocumentOutputDto {
    private long id;
    private String type;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private int copies;
}
