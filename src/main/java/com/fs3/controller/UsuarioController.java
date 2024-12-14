package com.fs3.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs3.dto.AutenticacionUsuario;
import com.fs3.model.Usuario;
import com.fs3.service.UsuarioService;




@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/usuarios")
public class UsuarioController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioByID(@PathVariable Long id) {
        Optional<Usuario> usuOptional = usuarioService.getUsuarioByID(id);
        if (usuOptional.isEmpty()) {
            log.error("No se encontro ningun Usuario con ese ID {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro ningun Usuario con ese ID"));
        }
        return ResponseEntity.ok(usuOptional);
    }

    @PostMapping
    public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario){

        Usuario u = usuarioService.crearUsuario(usuario);
        if(u == null){
            log.error("Error al crear el Usuario");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error al crear el Usuario"));
        }
        return ResponseEntity.ok(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Optional<Usuario> usuOptional = usuarioService.getUsuarioByID(id);
        if (usuOptional.isEmpty()) {
            log.error("No se encontro ningun Usuario con ese ID {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro ningun Usuario con ese ID"));
        }

        Usuario u = usuarioService.actualizarUsuario(id, usuario);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id){
        Optional<Usuario> usuOptional = usuarioService.getUsuarioByID(id);
        if (usuOptional.isEmpty()) {
            log.error("No se encontro ningun Usuario con ese ID {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro ningun Usuario con ese ID"));
        }

        usuarioService.eliminarUsuario(id);
        // return ResponseEntity.ok("Usuario eliminado");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public ResponseEntity<Object> autenticarUsuario(@RequestBody AutenticacionUsuario parms){

        boolean validacion = usuarioService.autenticarUsuario(parms.getCorreo(), parms.getContrasena());
        if (validacion) {
            return ResponseEntity.ok().body(new ErrorResponse("El usuario fue autenticado exitosamente"));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse("Las credenciales ingresadas son incorrectas"));
    }
    

    
    
    static class ErrorResponse {
        private final String message;
    
        public ErrorResponse(String message){
            this.message = message;
        }
    
        public String getMessage(){
            return message;
        }
        
    }
}
