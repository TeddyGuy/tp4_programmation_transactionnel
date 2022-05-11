package com.javatown.backend.repository;

import com.javatown.backend.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("select d " +
            "from Document d " +
            "where LOWER(d.title) like lower(concat('%', :titleSearch,'%')) " +
            "and LOWER(d.author) like lower(concat('%', :authorSearch,'%')) " +
            "and LOWER(d.genre)like lower(concat('%', :genreSearch,'%')) " +
            "and d.publicationYear = :publicationYearSearch")
    List<Document> findAllByTitleAndAuthorAndGenreAndPublicationYear(@Param("titleSearch") String titleSearch,
                                                                     @Param("authorSearch") String author,
                                                                     @Param("genreSearch") String genre,
                                                                     @Param("publicationYearSearch") int publicationYear);
    @Query("select d " +
            "from Document d " +
            "where LOWER(d.title) like lower(concat('%', :titleSearch,'%')) " +
            "and LOWER(d.author) like lower(concat('%', :authorSearch,'%')) " +
            "and LOWER(d.genre)like lower(concat('%', :genreSearch,'%')) ")
    List<Document> findAllByTitleAndAuthorAndGenre(@Param("titleSearch") String titleSearch,
                                                   @Param("authorSearch") String author,
                                                   @Param("genreSearch") String genre);
}
