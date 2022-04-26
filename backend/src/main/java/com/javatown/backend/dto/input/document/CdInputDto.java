package com.javatown.backend.dto.input.document;

import com.javatown.backend.model.document.Cd;
import com.javatown.backend.model.document.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CdInputDto extends DocumentInputDto{
    @Override
    public Document toDocument() {
        return new Cd(title,author,genre,publicationYear);
    }
}
