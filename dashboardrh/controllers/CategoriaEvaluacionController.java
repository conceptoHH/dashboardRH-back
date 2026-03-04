package com.chaindrenciales.dashboardrh.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaindrenciales.dashboardrh.dto.CategoriaVacanteResponseDTO;
import com.chaindrenciales.dashboardrh.services.CategoriaService;

@RestController
@RequestMapping("/api/dashboard-liderRH/categorias-evaluacion") // Ruta del doc [cite: 1656]
public class CategoriaEvaluacionController {

    private final CategoriaService categoriaService;

    public CategoriaEvaluacionController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // GET /api/dashboard-liderRH/categorias-evaluacion [cite: 1656]
    @GetMapping
    public ResponseEntity<List<CategoriaVacanteResponseDTO>> obtenerListadoCategorias() {
        
        List<CategoriaVacanteResponseDTO> categorias = categoriaService.obtenerCategoriasActivas();

        return ResponseEntity.ok(categorias);
    }
}