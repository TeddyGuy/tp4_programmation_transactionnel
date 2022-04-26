package com.javatown.backend.dto.input.document;

import com.javatown.backend.model.document.Document;
import com.javatown.backend.model.document.Dvd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdInputDto extends DocumentInputDto{
    @Override
    public Document toDocument() {
        return new Dvd(title,author,genre,publicationYear);
    }
}
