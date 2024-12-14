package com.fs3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(name = "nombre_completo_usuario")
    private String nombreCompleto;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "correo_usuario", unique = true)
    private String correoUsuario;
    @Column(name = "direccion_despacho")
    private String direccionDespacho;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name = "sesion")
    private boolean sesionIniciada;
    @Column(name = "contrasena")
    private String contrasena;
    
    @Column(name = "rol_usuario")
    private String rol;
    
    public Usuario() {
    }

    public Usuario(Long id, String nombreCompleto, String nombreUsuario, String correoUsuario, String direccionDespacho,
            String fechaNacimiento, boolean sesionIniciada, String contrasena, String rol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.direccionDespacho = direccionDespacho;
        this.fechaNacimiento = fechaNacimiento;
        this.sesionIniciada = sesionIniciada;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getDireccionDespacho() {
        return direccionDespacho;
    }

    public void setDireccionDespacho(String direccionDespacho) {
        this.direccionDespacho = direccionDespacho;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}

    