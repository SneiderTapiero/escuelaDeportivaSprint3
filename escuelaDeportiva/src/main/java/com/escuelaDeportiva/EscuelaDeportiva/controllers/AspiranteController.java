package com.escuelaDeportiva.EscuelaDeportiva.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.escuelaDeportiva.EscuelaDeportiva.exceptions.CustomException;
import com.escuelaDeportiva.EscuelaDeportiva.models.AspiranteModel;
import com.escuelaDeportiva.EscuelaDeportiva.services.AspiranteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AspiranteController {

    @Autowired
    AspiranteService aspiranteService;

    @PostMapping("/aspirantes")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody AspiranteModel aspirante, Errors error) {
        if (error.hasErrors()) {
            throwError(error);
        }

        this.aspiranteService.guardarAspirante(aspirante);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Se agrego el aspirante correctamente");
        respuesta.put("estado", "true");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/aspirantes")
    public List<AspiranteModel> mostrar() {
        return aspiranteService.traerTodos();
    }

    @PutMapping("/aspirantes")
    public ResponseEntity<Map<String, String>> actualizar(@Valid @RequestBody AspiranteModel aspirante) {
        this.aspiranteService.guardarAspirante(aspirante);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Se actualizo el aspirante correctamente");
        respuesta.put("estado", "true");
        return ResponseEntity.ok(respuesta);
    }

    public void throwError(Errors error) {
        String mensaje = "";
        int index = 0;

        for (ObjectError e : error.getAllErrors()) {
            if (index > 0) {
                mensaje += " | ";
            }

            mensaje += String.format("Parametro: %s - Mensaje: %s", e.getObjectName(), e.getDefaultMessage());
        }

        throw new CustomException(mensaje);
    }
}
