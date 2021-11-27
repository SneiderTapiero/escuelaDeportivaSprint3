package com.escuelaDeportiva.EscuelaDeportiva.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.escuelaDeportiva.EscuelaDeportiva.exceptions.CustomException;
import com.escuelaDeportiva.EscuelaDeportiva.models.AcudienteModel;
import com.escuelaDeportiva.EscuelaDeportiva.services.AcudienteService;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AcudienteController {

    @Autowired
    AcudienteService acudienteService;

    @PostMapping("/acudiente")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody AcudienteModel acudiente) {
        this.acudienteService.guardarAcudiente(acudiente);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Se ha agregado al acudiente correctamente");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/acudiente")
    public List<AcudienteModel> mostrar() {
        return this.acudienteService.obtenerAcudiente();
    }

    @PutMapping("/acudiente")
    public ResponseEntity<Map<String, String>> actualizar(@Valid @RequestBody AcudienteModel acudiente) {
        this.acudienteService.guardarAcudiente(acudiente);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Se actualizo el acudiente correctamente");
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
