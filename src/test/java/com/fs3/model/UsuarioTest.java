package com.fs3.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testConstructorVacio() {
        Usuario usuario = new Usuario();
        assertNotNull(usuario);
        assertNull(usuario.getId());
        assertNull(usuario.getNombreCompleto());
        assertNull(usuario.getNombreUsuario());
        assertNull(usuario.getCorreoUsuario());
        assertNull(usuario.getDireccionDespacho());
        assertNull(usuario.getFechaNacimiento());
        assertFalse(usuario.isSesionIniciada());
        assertNull(usuario.getContrasena());
        assertNull(usuario.getRol());
    }

    @Test
    public void testConstructorConParametros() {
        Long id = 1L;
        String nombreCompleto = "Juan Pérez";
        String nombreUsuario = "juanperez";
        String correoUsuario = "juanperez@example.com";
        String direccionDespacho = "Calle 123";
        String fechaNacimiento = "1990-01-01";
        boolean sesionIniciada = true;
        String contrasena = "password";
        String rol = "admin";

        Usuario usuario = new Usuario(id, nombreCompleto, nombreUsuario, correoUsuario, direccionDespacho, fechaNacimiento, sesionIniciada, contrasena, rol);
        assertNotNull(usuario);
        assertEquals(id, usuario.getId());
        assertEquals(nombreCompleto, usuario.getNombreCompleto());
        assertEquals(nombreUsuario, usuario.getNombreUsuario());
        assertEquals(correoUsuario, usuario.getCorreoUsuario());
        assertEquals(direccionDespacho, usuario.getDireccionDespacho());
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
        assertTrue(usuario.isSesionIniciada());
        assertEquals(contrasena, usuario.getContrasena());
        assertEquals(rol, usuario.getRol());
    }

    @Test
    public void testGettersYSetters() {
        Usuario usuario = new Usuario();
        Long id = 1L;
        String nombreCompleto = "Juan Pérez";
        String nombreUsuario = "juanperez";
        String correoUsuario = "juanperez@example.com";
        String direccionDespacho = "Calle 123";
        String fechaNacimiento = "1990-01-01";
        boolean sesionIniciada = true;
        String contrasena = "password";
        String rol = "admin";

        usuario.setId(id);
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setCorreoUsuario(correoUsuario);
        usuario.setDireccionDespacho(direccionDespacho);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setSesionIniciada(sesionIniciada);
        usuario.setContrasena(contrasena);
        usuario.setRol(rol);

        assertEquals(id, usuario.getId());
        assertEquals(nombreCompleto, usuario.getNombreCompleto());
        assertEquals(nombreUsuario, usuario.getNombreUsuario());
        assertEquals(correoUsuario, usuario.getCorreoUsuario());
        assertEquals(direccionDespacho, usuario.getDireccionDespacho());
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
        assertTrue(usuario.isSesionIniciada());
        assertEquals(contrasena, usuario.getContrasena());
        assertEquals(rol, usuario.getRol());
    }
}