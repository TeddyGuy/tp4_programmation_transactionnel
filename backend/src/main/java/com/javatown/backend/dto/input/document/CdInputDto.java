package com.javatown.backend.dto.input.document;

import com.javatown.backend.model.document.Cd;
import com.javatown.backend.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CdInputDto extends DocumentInputDto{
    public CdInputDto(String title,
                      String author,
                      String genre,
                      int publicationYear) {
        super(title, author, genre, publicationYear, 1);
    }

    public CdInputDto(String title,
                      String author,
                      String genre,
                      int publicationYear,
                      int copies) {
        super(title, author, genre, publicationYear, copies);
    }

    @Override
    public Document toDocument() {
        return new Cd(title,author,genre,publicationYear);
    }
}
