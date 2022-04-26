package com.javatown.backend.dto.document;

public class CDDTO extends DocumentDTO{
    public CDDTO(long id, String title, String author, String genre, int publicationYear, int copies) {
        super(id, "cd", title, author, genre, publicationYear, copies);
    }
}
