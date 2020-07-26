package eaj.tads.projeto3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eaj.tads.projeto3.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}