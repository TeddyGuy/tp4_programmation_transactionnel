package com.javatown.backend.dto.output.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CdOutputDto extends DocumentOutputDto {
    public CdOutputDto(long id, String title, String author, String genre, int publicationYear, int copies) {
        super(id, "cd", title, author, genre, publicationYear, copies);
    }
}
