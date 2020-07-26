package eaj.tads.projeto3.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eaj.tads.projeto3.model.Musica;
import eaj.tads.projeto3.services.MusicaService;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    private MusicaService service;

    public MusicaController(MusicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Musica> listAll() {
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Musica> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Musica> insert(@RequestBody Musica musica) {
        service.insert(musica);
        return ResponseEntity.status(201).body(musica);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Musica> update(@PathVariable Long id, @RequestBody Musica musica) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(musica);
            return ResponseEntity.ok().body(musica);
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