package com.fs3.service;

import java.util.List;
import java.util.Optional;

import com.fs3.model.Usuario;


public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioByID(Long id);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
    boolean autenticarUsuario(String correo, String contrasena);
}
