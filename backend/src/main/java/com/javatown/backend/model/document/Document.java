package com.javatown.backend.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="documentType", discriminatorType = DiscriminatorType.STRING)

public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected String title;
    protected String author;
    protected String genre;
    protected int publicationYear;
    protected int copies = 1;

    public Document(String title,
                    String author,
                    String genre,
                    int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }
}