package eaj.tads.projeto3.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eaj.tads.projeto3.model.Artista;
import eaj.tads.projeto3.services.ArtistaService;

@RestController
@RequestMapping("/artista")
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistaController {
    private ArtistaService service;

    public ArtistaController(ArtistaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Artista> listAll() {
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Artista> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Artista> insert(@RequestBody Artista artista) {
        service.insert(artista);
        return ResponseEntity.status(201).body(artista);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Artista> update(@PathVariable Long id, @RequestBody Artista artista) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(artista);
            return ResponseEntity.ok().body(artista);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map(record -> {
            service.delete(record);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}