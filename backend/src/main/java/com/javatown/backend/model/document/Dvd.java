package com.javatown.backend.model.document;

import com.javatown.backend.dto.output.document.DocumentOutputDto;
import com.javatown.backend.dto.output.document.DvdOutputDto;
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

    @Override
    public DocumentOutputDto toOutputDto() {
        return new DvdOutputDto(id,title,author,genre,publicationYear,copies);
    }
}
