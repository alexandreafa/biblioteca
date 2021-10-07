package com.alexandreafa.biblioteca.repo;

import com.alexandreafa.biblioteca.domain.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObraRepository extends JpaRepository<Obra, Long> {

    Optional<Obra> findObraById(Long id);

    void deleteObraById(Long id);
}
