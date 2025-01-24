package com.projectsensor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectsensor.project.dto.LoginDTO;
import com.projectsensor.project.entities.Usuario;
import com.projectsensor.project.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(@RequestBody LoginDTO login) {
        return new ResponseEntity<>(service.autenticar(login), HttpStatus.OK);
    }    

    @PostMapping("/signup")
    public ResponseEntity<Usuario> signUpUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(service.create(usuario), HttpStatus.OK);
    }    
}
