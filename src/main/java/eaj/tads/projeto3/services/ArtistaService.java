package eaj.tads.projeto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eaj.tads.projeto3.model.Artista;
import eaj.tads.projeto3.repository.ArtistaRespository;

@Service
public class ArtistaService {

    private ArtistaRespository respository;

    @Autowired
    public ArtistaService(ArtistaRespository respository) {
        this.respository = respository;
    }

    public Artista insert(Artista artista) {
        return respository.save(artista);
    }

    public Artista update(Artista artista) {
        return respository.save(artista);
    }

    public void delete(Artista artista) {
        respository.delete(artista);
    }

    public Artista getOne(Long id) {
        return respository.findById(id).orElse(null);
    }

    public List<Artista> getAll() {
        return respository.findAll();
    }

    public Optional<Artista> findById(Long id) {
        return respository.findById(id);
    }

    public Artista saveAndFlush(Artista artista) {
        return respository.saveAndFlush(artista);
    }

}