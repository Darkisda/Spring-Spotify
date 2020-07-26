package eaj.tads.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eaj.tads.projeto3.model.Artista;

public interface ArtistaRespository extends JpaRepository<Artista, Long> {

}