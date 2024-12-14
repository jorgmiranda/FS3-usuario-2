package com.fs3.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AutenticacionUsuarioTest {

    @Test
    public void testConstructorVacio() {
        // Ejecución
        AutenticacionUsuario autenticacionUsuario = new AutenticacionUsuario();

        // Verificación
        assertNotNull(autenticacionUsuario);
        assertEquals(null, autenticacionUsuario.getCorreo());
        assertEquals(null, autenticacionUsuario.getContrasena());
    }

    @Test
    public void testConstructorConParametros() {
        // Ejecución
        AutenticacionUsuario autenticacionUsuario = new AutenticacionUsuario("correo@example.com", "contrasena");

        // Verificación
        assertNotNull(autenticacionUsuario);
        assertEquals("correo@example.com", autenticacionUsuario.getCorreo());
        assertEquals("contrasena", autenticacionUsuario.getContrasena());
    }

    @Test
    public void testGettersYSetters() {
        // Ejecución
        AutenticacionUsuario autenticacionUsuario = new AutenticacionUsuario();
        autenticacionUsuario.setCorreo("correo@example.com");
        autenticacionUsuario.setContrasena("contrasena");

        // Verificación
        assertEquals("correo@example.com", autenticacionUsuario.getCorreo());
        assertEquals("contrasena", autenticacionUsuario.getContrasena());
    }
}
