package com.javatown.backend.model.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("dvd")
@EqualsAndHashCode(callSuper = true)
public class Dvd extends Document{
    public final static int BORROW_TIME_IN_WEEK = 1;

    public Dvd(String title,
               String author,
               String genre,
               int publicationYear) {
        super(title, author, genre, publicationYear);
    }
}
