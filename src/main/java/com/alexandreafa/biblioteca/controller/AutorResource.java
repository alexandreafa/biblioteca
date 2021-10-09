package com.alexandreafa.biblioteca.controller;

import com.alexandreafa.biblioteca.domain.Autor;
import com.alexandreafa.biblioteca.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AutorResource {
    private final AutorService autorService;

    @PostMapping("/autores")
    public ResponseEntity<Autor> addAutor(@RequestBody Autor autor) {
        Autor newAutor = autorService.addAutor(autor);
        return new ResponseEntity<>(newAutor, HttpStatus.CREATED);
    }

    @GetMapping("/autores")
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = autorService.findAllAutores();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/autores/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable("id") Long id) {
        Autor autor = autorService.findAutorById(id);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PutMapping("/autores/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable("id") Long id, @RequestBody Autor autor) {
        Autor updateAutor = autorService.updateAutor(autor);
        return new ResponseEntity<>(updateAutor, HttpStatus.OK);
    }

    @DeleteMapping("/autores/{id}")
    public ResponseEntity<?> deleteAutor(@PathVariable("id") Long id) {
        autorService.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

