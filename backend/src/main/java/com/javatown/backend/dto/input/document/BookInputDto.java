package com.javatown.backend.dto.input.document;

import com.javatown.backend.model.document.Book;
import com.javatown.backend.model.document.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookInputDto extends DocumentInputDto {
    private String publisher;
    private int pages;

    public BookInputDto(String title, String author, String genre, String publisher, int publicationYear, int pages) {
        super(title, author, genre, publicationYear);
        this.publisher = publisher;
        this.pages = pages;
    }

    @Override
    public Document toDocument(){
        return new Book(title,author,genre,publicationYear,publisher,pages);
    }

    @Override
    public String getMissingFields() {
        String missingFields = super.getMissingFields();

        if(publisher == null || publisher.isBlank()) missingFields += "publisher, ";
        
        return missingFields;
    }
}
