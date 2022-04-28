package com.javatown.backend.model.document;


import com.javatown.backend.dto.input.document.BookInputDto;
import com.javatown.backend.dto.input.document.DocumentInputDto;
import com.javatown.backend.dto.output.document.BookOutputDto;
import com.javatown.backend.dto.output.document.DocumentOutputDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("book")
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

    public void update(BookInputDto inputDto) {
        super.update(inputDto);
        if(!(inputDto.getPublisher() == null || inputDto.getPublisher().isBlank())) this.publisher = inputDto.getPublisher();
        if(!(inputDto.getPages() <= 0)) this.pages = inputDto.getPages();
    }

    @Override
    public DocumentOutputDto toOutputDto() {
        return new BookOutputDto(id,title,author,genre,publicationYear,copies,publisher,pages);
    }
}
