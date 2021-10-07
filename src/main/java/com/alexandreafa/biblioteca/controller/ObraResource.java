package com.alexandreafa.biblioteca.controller;

import com.alexandreafa.biblioteca.domain.Obra;
import com.alexandreafa.biblioteca.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ObraResource {
    private final ObraService obraService;

    @PostMapping("/obras")
    public ResponseEntity<Obra> addObra(@RequestBody Obra obra) {
        Obra newObra = obraService.addObra(obra);
        return new ResponseEntity<>(newObra, HttpStatus.CREATED);
    }

    @GetMapping("/obras")
    public ResponseEntity<List<Obra>> getAllObras() {
        List<Obra> obras = obraService.findAllObras();
        return new ResponseEntity<>(obras, HttpStatus.OK);
    }

    @GetMapping("/obras/{id}")
    public ResponseEntity<Obra> getObraById(@PathVariable("id") Long id) {
        Obra obra = obraService.findObraById(id);
        return new ResponseEntity<>(obra, HttpStatus.OK);
    }

    @PutMapping("/obras/{id}")
    public ResponseEntity<Obra> updateObra(@PathVariable("id") Long id,@RequestBody Obra obra) {
        Obra updateObra = obraService.updateObra(obra);
        return new ResponseEntity<>(updateObra, HttpStatus.OK);
    }

    @DeleteMapping("/obras/{id}")
    public ResponseEntity<?> deleteObra(@PathVariable("id") Long id) {
        obraService.deleteObra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

