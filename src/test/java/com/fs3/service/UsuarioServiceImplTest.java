package com.fs3.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fs3.model.Usuario;
import com.fs3.repository.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    public void testGetAllUsuarios() {
        // Configuración
        List<Usuario> usuarios = List.of(new Usuario(1L, "Nombre Completo", "Nombre Usuario", "correo@example.com", "Direccion Despacho", "Fecha Nacimiento", false, "Contrasena", "Rol"));
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        // Ejecución
        List<Usuario> response = usuarioService.getAllUsuarios();

        // Verificación
        assertEquals(usuarios, response);
    }

    @Test
    public void testGetUsuarioByID() {
        // Configuración
        Usuario usuario = new Usuario(1L, "Nombre Completo", "Nombre Usuario", "correo@example.com", "Direccion Despacho", "Fecha Nacimiento", false, "Contrasena", "Rol");
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));

        // Ejecución
        Optional<Usuario> response = usuarioService.getUsuarioByID(1L);

        // Verificación
        assertEquals(Optional.of(usuario), response);
    }

    @Test
    public void testGetUsuarioByIDNotFound() {
        // Configuración
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Ejecución
        Optional<Usuario> response = usuarioService.getUsuarioByID(1L);

        // Verificación
        assertEquals(Optional.empty(), response);
    }

    @Test
    public void testCrearUsuario() {
        // Configuración
        Usuario usuario = new Usuario(1L, "Nombre Completo", "Nombre Usuario", "correo@example.com", "Direccion Despacho", "Fecha Nacimiento", false, "Contrasena", "Rol");
        when(usuarioRepository.save(any())).thenReturn(usuario);

        // Ejecución
        Usuario response = usuarioService.crearUsuario(usuario);

        // Verificación
        assertEquals(usuario, response);
    }

    @Test
    public void testActualizarUsuario() {
        // Configuración
        Usuario usuario = new Usuario(1L, "Nombre Completo", "Nombre Usuario", "correo@example.com", "Direccion Despacho", "Fecha Nacimiento", false, "Contrasena", "Rol");
        when(usuarioRepository.existsById(anyLong())).thenReturn(true);
        when(usuarioRepository.save(any())).thenReturn(usuario);

        // Ejecución
        Usuario response = usuarioService.actualizarUsuario(1L, usuario);

        // Verificación
        assertEquals(usuario, response);
    }

    @Test
    public void testActualizarUsuarioNotFound() {
        // Configuración
        when(usuarioRepository.existsById(anyLong())).thenReturn(false);

        // Ejecución
        Usuario response = usuarioService.actualizarUsuario(1L, new Usuario());

        // Verificación
        assertNull(response);
    }

    @Test
    public void testEliminarUsuario() {
        // Ejecución
        usuarioService.eliminarUsuario(1L);

        // Verificación
        // No hay nada que verificar, solo se ejecuta el método
    }

    @Test
    public void testAutenticarUsuario() {
        // Configuración
        Usuario usuario = new Usuario(1L, "Nombre Completo", "Nombre Usuario", "correo@example.com", "Direccion Despacho", "Fecha Nacimiento", false, "Contrasena", "Rol");
        when(usuarioRepository.findByCorreoUsuarioAndContrasena(any(), any())).thenReturn(Optional.of(usuario));

        // Ejecución
        boolean response = usuarioService.autenticarUsuario("correo@example.com", "Contrasena");

        // Verificación
        assertEquals(true, response);
    }

    @Test
    public void testAutenticarUsuarioNotFound() {
        // Configuración
        when(usuarioRepository.findByCorreoUsuarioAndContrasena(any(), any())).thenReturn(Optional.empty());

        // Ejecución
        boolean response = usuarioService.autenticarUsuario("correo@example.com", "Contrasena");

        // Verificación
        assertEquals(false, response);
    }
}