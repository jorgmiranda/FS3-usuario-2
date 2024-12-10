package com.fs3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs3.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByCorreoUsuarioAndContrasena(String correo, String contrasena);
}
