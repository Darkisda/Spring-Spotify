package eaj.tads.projeto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eaj.tads.projeto3.model.Playlist;
import eaj.tads.projeto3.repository.PlaylistRepository;

@Service
public class PlaylistService {

    private PlaylistRepository repository;

    public PlaylistService(PlaylistRepository repository) {
        this.repository = repository;
    }

    public Playlist insert(Playlist playlist) {
        return repository.save(playlist);
    }

    public Playlist update(Playlist playlist) {
        return repository.save(playlist);
    }

    public void delete(Playlist playlist) {
        repository.delete(playlist);
    }

    public Playlist getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Playlist> getAll() {
        return repository.findAll();
    }

    public Optional<Playlist> findById(Long id) {
        return repository.findById(id);
    }

    public Playlist saveAndFlush(Playlist playlist) {
        return repository.saveAndFlush(playlist);
    }
}