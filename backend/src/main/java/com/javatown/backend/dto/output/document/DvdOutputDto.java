package com.javatown.backend.dto.output.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdOutputDto extends DocumentOutputDto {
    public DvdOutputDto(long id, String title, String author, String genre, int publicationYear, int copies) {
        super(id, "dvd", title, author, genre, publicationYear, copies);
    }
}
