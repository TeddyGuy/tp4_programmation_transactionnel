package com.javatown.backend.dto.input.document;

import com.javatown.backend.model.document.Book;
import com.javatown.backend.model.document.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInputDto extends DocumentInputDto {
    private String publisher;
    private int pages;

    @Override
    public Document toDocument(){
        return new Book(title,author,genre,publicationYear,publisher,pages);
    }
}
