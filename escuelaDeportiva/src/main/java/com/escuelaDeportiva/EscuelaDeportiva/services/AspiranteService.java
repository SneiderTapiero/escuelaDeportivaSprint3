package com.escuelaDeportiva.EscuelaDeportiva.services;

import java.util.List;

import com.escuelaDeportiva.EscuelaDeportiva.models.AspiranteModel;
import com.escuelaDeportiva.EscuelaDeportiva.repositories.AspiranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AspiranteService {

    @Autowired
    AspiranteRepository aspiranteRepository;

    public void guardarAspirante(AspiranteModel aspirante) {
        this.aspiranteRepository.save(aspirante);
    }

    public List<AspiranteModel> traerTodos() {
        return this.aspiranteRepository.findAll();
    }
}
