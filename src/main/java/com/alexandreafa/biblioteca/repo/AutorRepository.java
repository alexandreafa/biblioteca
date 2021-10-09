package com.alexandreafa.biblioteca.repo;

import com.alexandreafa.biblioteca.domain.Autor;
import com.alexandreafa.biblioteca.domain.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findAutorById(Long id);

    void deleteAutorById(Long id);
}
