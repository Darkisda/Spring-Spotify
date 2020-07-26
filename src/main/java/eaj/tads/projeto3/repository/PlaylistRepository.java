package eaj.tads.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eaj.tads.projeto3.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

}