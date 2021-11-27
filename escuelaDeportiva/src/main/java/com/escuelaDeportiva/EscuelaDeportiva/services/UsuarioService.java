package com.escuelaDeportiva.EscuelaDeportiva.services;

import com.escuelaDeportiva.EscuelaDeportiva.models.UsuarioModel;
import com.escuelaDeportiva.EscuelaDeportiva.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // Método para guardar usuario
    public void guardarUsuario(UsuarioModel usuario) {
        this.usuarioRepository.save(usuario);
    }

    // Método para listar todos los usuarios
    public List<UsuarioModel> traerTodos() {
        return this.usuarioRepository.findAll();
    }

    // Método para buscar por ID
    public Optional<UsuarioModel> buscarPorId(String id) {
        return this.usuarioRepository.findById(id);
    }

    // metodo para buscar usuario
    public UsuarioModel buscarUserName(String username) {
        return this.usuarioRepository.findByUsername(username).orElse(new UsuarioModel());
    }

}
