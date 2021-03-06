package com.javatown.backend.model.document;

import com.javatown.backend.dto.input.document.DocumentInputDto;
import com.javatown.backend.dto.output.document.DocumentOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="documentType", discriminatorType = DiscriminatorType.STRING)

public abstract class Document {
    public final static int BORROW_TIME_IN_WEEK = 1;

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

    public abstract DocumentOutputDto toOutputDto();

    public static <T extends Document> List<DocumentOutputDto> toDocumentOutputDtoList(List<T> documents){
        List<DocumentOutputDto> documentOutputDtos = new ArrayList<>();

        for (T document : documents) {
            documentOutputDtos.add(document.toOutputDto());
        }

        return documentOutputDtos;
    }

    public <T extends DocumentInputDto> void  update(T inputDto){
        if(!(inputDto.getTitle() == null || inputDto.getTitle().isBlank())) this.title = inputDto.getTitle();
        if(!(inputDto.getAuthor() == null || inputDto.getAuthor().isBlank())) this.author = inputDto.getAuthor();
        if(!(inputDto.getGenre() == null || inputDto.getGenre().isBlank())) this.genre = inputDto.getGenre();
        if(!(inputDto.getPublicationYear() <= 0)) this.publicationYear = inputDto.getPublicationYear();
        if(!(inputDto.getCopies() <= 0)) this.copies = inputDto.getCopies();
    }

    public int getBorrowTimeInWeeks(){

        if (this instanceof Book) return Book.BORROW_TIME_IN_WEEKS;
        if (this instanceof Dvd) return Dvd.BORROW_TIME_IN_WEEK;
        if (this instanceof Cd) return Cd.BORROW_TIME_IN_WEEK;

        return Document.BORROW_TIME_IN_WEEK;
    }
}