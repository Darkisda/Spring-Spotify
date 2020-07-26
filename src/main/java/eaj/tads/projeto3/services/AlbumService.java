package eaj.tads.projeto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eaj.tads.projeto3.model.Album;
import eaj.tads.projeto3.repository.AlbumRepository;

@Service
public class AlbumService {

    private AlbumRepository repository;

    @Autowired
    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    public Album insert(Album album) {
        return repository.save(album);
    }

    public Album update(Album album) {
        return repository.save(album);
    }

    public void delete(Album album) {
        repository.delete(album);
    }

    public Album getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Album> getAll() {
        return repository.findAll();
    }

    public Optional<Album> findById(Long id) {
        return repository.findById(id);
    }

    public Album saveAndFlush(Album album) {
        return repository.saveAndFlush(album);
    }
}