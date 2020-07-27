package eaj.tads.projeto3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eaj.tads.projeto3.model.Usuario;
import eaj.tads.projeto3.services.CredenciaisService;
import eaj.tads.projeto3.services.UsuarioService;

@RestController
@RequestMapping("/")
public class IndexController {
    private CredenciaisService credenciaisService;
    private UsuarioService usuarioService;

    public IndexController(CredenciaisService credenciaisService, UsuarioService usuarioService) {
        this.credenciaisService = credenciaisService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().body(null);
    }

    @PostMapping(path = { "/registro" })
    public ResponseEntity<Usuario> registro(@RequestBody Usuario usuario) {
        usuarioService.insert(usuario);
        return ResponseEntity.status(201).build();
    }
}