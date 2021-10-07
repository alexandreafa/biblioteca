package com.alexandreafa.biblioteca.service;

import com.alexandreafa.biblioteca.domain.Obra;
import com.alexandreafa.biblioteca.exception.ObraNotFoundException;
import com.alexandreafa.biblioteca.repo.ObraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ObraService {
    private final ObraRepository obraRepository;

    public Obra addObra(Obra obra) {
        obra.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        return obraRepository.save(obra);
    }

    public List<Obra> findAllObras() {
        return obraRepository.findAll();
    }

    public Obra updateObra(Obra obra) {
        return  obraRepository.save(obra);
    }

    public Obra findObraById(Long id) {
        return obraRepository.findObraById(id)
                .orElseThrow(() -> new ObraNotFoundException("Obra by id " + id + " was not found"));
    }

    @Transactional
    public void deleteObra(Long id) {
        obraRepository.deleteObraById(id);
    }
}
