package com.javatown.backend.repository;

import com.javatown.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c left join fetch c.borrowingHistory where c.id = :id")
    Optional<Client> findByIdWithBorrowingHistory(@Param("id") long id);
}
