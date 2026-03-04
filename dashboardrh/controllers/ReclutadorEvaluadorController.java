package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaindrenciales.dashboardrh.services.ReclutadorEvaluadorService;
import com.chaindrenciales.dashboardrh.dto.ReclutadorEvaluadorRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorEvaluadorResponseDTO;

@RestController
@RequestMapping("/reclutador-evaluador")
public class ReclutadorEvaluadorController {

    private final ReclutadorEvaluadorService service;

    public ReclutadorEvaluadorController(ReclutadorEvaluadorService service) {
        this.service = service;
    }

    @PostMapping
    public ReclutadorEvaluadorResponseDTO asignar(@RequestBody ReclutadorEvaluadorRequestDTO request) {
        return service.asignar(
                request.getReclutadorId(),
                request.getEvaluadorId(),
                request.getEmpresaId()
        );
    }
}