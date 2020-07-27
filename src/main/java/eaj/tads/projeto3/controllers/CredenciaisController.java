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

import eaj.tads.projeto3.model.Credenciais;
import eaj.tads.projeto3.services.CredenciaisService;

@RestController
@RequestMapping("/credenciais")
@CrossOrigin(origins = "http://localhost:3000")
public class CredenciaisController {
    private CredenciaisService service;

    public CredenciaisController(CredenciaisService service) {
        this.service = service;
    }

    @GetMapping
    public List<Credenciais> listAll() {
        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Credenciais> findById(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Credenciais> insert(@RequestBody Credenciais credenciais) {
        service.insert(credenciais);
        return ResponseEntity.status(201).body(credenciais);
    }

    @PutMapping(value = { "/{id}" })
    public ResponseEntity<Credenciais> update(@PathVariable Long id, @RequestBody Credenciais credenciais) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(credenciais);
            return ResponseEntity.ok().body(credenciais);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> dekete(@PathVariable Long id) {
        return service.findById(id).map(record -> {
            service.delete(record);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}