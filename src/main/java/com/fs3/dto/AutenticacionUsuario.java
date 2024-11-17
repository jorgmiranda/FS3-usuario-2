package com.fs3.dto;

public class AutenticacionUsuario {
    private String correo;
    private String contrasena;

    public AutenticacionUsuario() {
    }
    
    public AutenticacionUsuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
}