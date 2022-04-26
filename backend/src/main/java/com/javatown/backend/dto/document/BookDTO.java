package com.javatown.backend.dto.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDTO extends DocumentDTO{
    private String publisher;
    private int pages;

    public BookDTO(long id, String title, String author, String genre, int publicationYear, int copies, String publisher, int pages) {
        super(id, "book", title, author, genre, publicationYear, copies);
        this.publisher = publisher;
        this.pages = pages;
    }
}
