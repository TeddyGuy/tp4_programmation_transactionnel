package com.javatown.backend.dto.input.document;

import com.javatown.backend.model.document.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DocumentInputDto {
    protected String title;
    protected String author;
    protected String genre;
    protected int publicationYear;
    protected int copies;

    public abstract Document toDocument();

    public String getMissingFields(){
        String missingFields = "";

        if(title == null || title.isBlank()) missingFields += "title, ";
        if(author == null || author.isBlank()) missingFields += "author, ";
        if(genre == null || genre.isBlank()) missingFields += "genre, ";
        if(publicationYear == 0) missingFields += "publicationYear ";

        return missingFields;
    }
}
