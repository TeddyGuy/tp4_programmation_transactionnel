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

    public abstract Document toDocument();
}
