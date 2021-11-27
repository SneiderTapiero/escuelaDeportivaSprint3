package com.escuelaDeportiva.EscuelaDeportiva.repositories;

import java.util.Optional;

import com.escuelaDeportiva.EscuelaDeportiva.models.UsuarioModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioModel, String> {

    // Para buscar un usuario por nombre de usuario (username)
    public Optional<UsuarioModel> findByUsername(String username);

}