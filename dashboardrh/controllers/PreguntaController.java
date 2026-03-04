package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.models.Pregunta;
import com.chaindrenciales.dashboardrh.services.PreguntaService;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    private final PreguntaService preguntaService;

    public PreguntaController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @PostMapping
    public ResponseEntity<Pregunta> crearPregunta(@RequestBody Pregunta pregunta) {
        Pregunta nuevaPregunta = preguntaService.crearPregunta(pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPregunta);
    }
}