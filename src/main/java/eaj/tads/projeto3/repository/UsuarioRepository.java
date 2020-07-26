package eaj.tads.projeto3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eaj.tads.projeto3.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByid(Long id);
}