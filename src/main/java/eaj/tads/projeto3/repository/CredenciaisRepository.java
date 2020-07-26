package eaj.tads.projeto3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eaj.tads.projeto3.model.Credenciais;

public interface CredenciaisRepository extends JpaRepository<Credenciais, Long> {
    List<Credenciais> findAllByid(Long id);
}