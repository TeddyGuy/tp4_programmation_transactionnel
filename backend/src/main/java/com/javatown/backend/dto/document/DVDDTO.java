package com.javatown.backend.dto.document;

public class DVDDTO extends DocumentDTO{
    public DVDDTO(long id, String title, String author, String genre, int publicationYear, int copies) {
        super(id, "dvd", title, author, genre, publicationYear, copies);
    }
}
