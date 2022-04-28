package com.javatown.backend.dto.input.document;

import com.javatown.backend.model.document.Document;
import com.javatown.backend.model.document.Dvd;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdInputDto extends DocumentInputDto{
    public DvdInputDto(String title,
                       String author,
                       String genre,
                       int publicationYear) {
        super(title, author, genre, publicationYear,1);
    }

    public DvdInputDto(String title,
                      String author,
                      String genre,
                      int publicationYear,
                      int copies) {
        super(title, author, genre, publicationYear, copies);
    }

    @Override
    public Document toDocument() {
        return new Dvd(title,author,genre,publicationYear);
    }
}
