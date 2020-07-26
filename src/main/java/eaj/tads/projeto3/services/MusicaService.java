package eaj.tads.projeto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eaj.tads.projeto3.model.Musica;
import eaj.tads.projeto3.repository.MusicaRepository;

@Service
public class MusicaService {

    private MusicaRepository repository;

    public MusicaService(MusicaRepository repository) {
        this.repository = repository;
    }

    public Musica insert(Musica musica) {
        return repository.save(musica);
    }

    public Musica update(Musica musica) {
        return repository.save(musica);
    }

    public void delete(Musica musica) {
        repository.delete(musica);
    }

    public Musica getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Musica> getAll() {
        return repository.findAll();
    }

    public Optional<Musica> findById(Long id) {
        return repository.findById(id);
    }

    public Musica saveAndFlush(Musica musica) {
        return repository.saveAndFlush(musica);
    }
}