package com.javatown.backend.model.document;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Book")
@EqualsAndHashCode(callSuper = true)
public class Book extends Document{
    public final static int BORROW_TIME_IN_WEEKS = 3;
    private String publisher;
    private int pages;

    public Book(String title,
                String author,
                String genre,
                int publicationYear,
                String publisher,
                int pages) {
        super(title, author, genre, publicationYear);
        this.publisher = publisher;
        this.pages = pages;
    }
}
