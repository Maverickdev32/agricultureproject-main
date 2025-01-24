package com.projectsensor.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsensor.project.dto.LoginDTO;
import com.projectsensor.project.entities.Usuario;
import com.projectsensor.project.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.java.Log;

@Service
@Log
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(LoginDTO login){
        String usuario = login.getUsuario();
        log.info(usuario);    
        Usuario usuarioencontrado = usuarioRepository.findByUsername(usuario).orElseThrow(() -> new EntityNotFoundException("No se encuentra registrado el usuario"));
        if (!usuarioencontrado.getPassword().equals(login.getContrasenia())) {
            throw new RuntimeException("Las credenciales no coinciden");
        } 
        return usuarioencontrado;
    }

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
