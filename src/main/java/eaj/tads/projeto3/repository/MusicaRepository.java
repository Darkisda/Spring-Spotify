package eaj.tads.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eaj.tads.projeto3.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}