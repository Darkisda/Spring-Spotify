package eaj.tads.projeto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eaj.tads.projeto3.model.Credenciais;
import eaj.tads.projeto3.repository.CredenciaisRepository;

@Service
public class CredenciaisService {

    private CredenciaisRepository repository;

    @Autowired
    public void setRepository(CredenciaisRepository repository) {
        this.repository = repository;
    }

    public Credenciais insert(Credenciais credenciais) {
        return repository.save(credenciais);
    }

    public Credenciais update(Credenciais credenciais) {
        return repository.save(credenciais);
    }

    public void delete(Credenciais credenciais) {
        repository.delete(credenciais);
    }

    public Credenciais getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Credenciais> getAll() {
        return repository.findAll();
    }

    public Optional<Credenciais> findById(Long id) {
        return repository.findById(id);
    }

    public Credenciais saveAndFlush(Credenciais credenciais) {
        return repository.saveAndFlush(credenciais);
    }
}