package com.alexandreafa.biblioteca.service;

import com.alexandreafa.biblioteca.domain.Autor;
import com.alexandreafa.biblioteca.exception.EntityNotFoundException;
import com.alexandreafa.biblioteca.repo.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;

    public Autor addAutor(Autor autor) {
        autor.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        return autorRepository.save(autor);
    }

    public List<Autor> findAllAutores() {
        return autorRepository.findAll();
    }

    public Autor updateAutor(Autor autor) {
        return  autorRepository.save(autor);
    }

    public Autor findAutorById(Long id) {
        return autorRepository.findAutorById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor by id " + id + " was not found"));
    }

    @Transactional
    public void deleteAutor(Long id) {
        autorRepository.deleteAutorById(id);
    }
}
