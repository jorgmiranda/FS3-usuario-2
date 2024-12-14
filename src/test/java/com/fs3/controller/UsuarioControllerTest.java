package com.fs3.controller;

import com.fs3.dto.AutenticacionUsuario;
import com.fs3.model.Usuario;
import com.fs3.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsuarios() {
        List<Usuario> usuarios = List.of(new Usuario(), new Usuario());
        when(usuarioService.getAllUsuarios()).thenReturn(usuarios);

        List<Usuario> result = usuarioController.getAllUsuarios();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(usuarioService, times(1)).getAllUsuarios();
    }

    @Test
    void testGetUsuarioByID_Success() {
        Usuario usuario = new Usuario();
        when(usuarioService.getUsuarioByID(1L)).thenReturn(Optional.of(usuario));

        ResponseEntity<Object> response = usuarioController.getUsuarioByID(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.of(usuario), response.getBody());
        verify(usuarioService, times(1)).getUsuarioByID(1L);
    }

    @Test
    void testGetUsuarioByID_NotFound() {
        when(usuarioService.getUsuarioByID(1L)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = usuarioController.getUsuarioByID(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(usuarioService, times(1)).getUsuarioByID(1L);
    }

    @Test
    void testCrearUsuario_Success() {
        Usuario usuario = new Usuario();
        when(usuarioService.crearUsuario(usuario)).thenReturn(usuario);

        ResponseEntity<Object> response = usuarioController.crearUsuario(usuario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).crearUsuario(usuario);
    }

    @Test
    void testCrearUsuario_Failure() {
        Usuario usuario = new Usuario();
        when(usuarioService.crearUsuario(usuario)).thenReturn(null);

        ResponseEntity<Object> response = usuarioController.crearUsuario(usuario);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(usuarioService, times(1)).crearUsuario(usuario);
    }

    @Test
    void testActualizarUsuario_Success() {
        Usuario usuario = new Usuario();
        when(usuarioService.getUsuarioByID(1L)).thenReturn(Optional.of(usuario));
        when(usuarioService.actualizarUsuario(1L, usuario)).thenReturn(usuario);

        ResponseEntity<Object> response = usuarioController.actualizarUsuario(1L, usuario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).getUsuarioByID(1L);
        verify(usuarioService, times(1)).actualizarUsuario(1L, usuario);
    }

    @Test
    void testActualizarUsuario_NotFound() {
        Usuario usuario = new Usuario();
        when(usuarioService.getUsuarioByID(1L)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = usuarioController.actualizarUsuario(1L, usuario);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(usuarioService, times(1)).getUsuarioByID(1L);
        verify(usuarioService, never()).actualizarUsuario(anyLong(), any());
    }

    @Test
    void testEliminarUsuario_Success() {
        Usuario usuario = new Usuario();
        when(usuarioService.getUsuarioByID(1L)).thenReturn(Optional.of(usuario));

        ResponseEntity<Object> response = usuarioController.eliminarUsuario(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(usuarioService, times(1)).getUsuarioByID(1L);
        verify(usuarioService, times(1)).eliminarUsuario(1L);
    }

    @Test
    void testEliminarUsuario_NotFound() {
        when(usuarioService.getUsuarioByID(1L)).thenReturn(Optional.empty());

        ResponseEntity<Object> response = usuarioController.eliminarUsuario(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(usuarioService, times(1)).getUsuarioByID(1L);
        verify(usuarioService, never()).eliminarUsuario(anyLong());
    }

    @Test
    void testAutenticarUsuario_Success() {
        AutenticacionUsuario auth = new AutenticacionUsuario("correo@test.com", "password");
        when(usuarioService.autenticarUsuario(auth.getCorreo(), auth.getContrasena())).thenReturn(true);

        ResponseEntity<Object> response = usuarioController.autenticarUsuario(auth);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(usuarioService, times(1)).autenticarUsuario(auth.getCorreo(), auth.getContrasena());
    }

    @Test
    void testAutenticarUsuario_Failure() {
        AutenticacionUsuario auth = new AutenticacionUsuario("correo@test.com", "wrongpassword");
        when(usuarioService.autenticarUsuario(auth.getCorreo(), auth.getContrasena())).thenReturn(false);

        ResponseEntity<Object> response = usuarioController.autenticarUsuario(auth);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(usuarioService, times(1)).autenticarUsuario(auth.getCorreo(), auth.getContrasena());
    }
}
