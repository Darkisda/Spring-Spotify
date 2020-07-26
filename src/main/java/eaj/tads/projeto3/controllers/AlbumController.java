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

import eaj.tads.projeto3.model.Album;
import eaj.tads.projeto3.services.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
    private AlbumService service;

    public AlbumController(AlbumService service) {
        this.service = service;
    }

    @GetMapping
    public List<Album> listAll() {
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Album> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Album> insert(@RequestBody Album album) {
        service.insert(album);
        return ResponseEntity.status(201).body(album);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Album> update(@PathVariable Long id, @RequestBody Album album) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(album);
            return ResponseEntity.ok().body(album);
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