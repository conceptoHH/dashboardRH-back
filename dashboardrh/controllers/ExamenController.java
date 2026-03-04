package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.ExamenRequestDTO;
import com.chaindrenciales.dashboardrh.models.Examen;
import com.chaindrenciales.dashboardrh.services.ExamenService;

@RestController
@RequestMapping("/dashboard-reclutador/examen")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @PostMapping
    public ResponseEntity<Examen> crearExamen(@RequestBody ExamenRequestDTO dto) {
        Examen nuevoExamen = examenService.crearExamen(dto);
        return ResponseEntity.ok(nuevoExamen);
    }
}