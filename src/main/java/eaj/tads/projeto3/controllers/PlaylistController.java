package eaj.tads.projeto3.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eaj.tads.projeto3.model.Playlist;
import eaj.tads.projeto3.services.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    private PlaylistService service;

    public PlaylistController(PlaylistService service) {
        this.service = service;
    }

    @GetMapping
    public List<Playlist> listAll() {
        return service.getAll();
    }

    @GetMapping(path = { "{/id}" })
    public ResponseEntity<Playlist> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Playlist> insert(@RequestBody Playlist playlist) {
        service.insert(playlist);
        return ResponseEntity.status(201).body(playlist);
    }
}