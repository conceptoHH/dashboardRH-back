package com.chaindrenciales.dashboardrh.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.CategoriaRequestDTO;
import com.chaindrenciales.dashboardrh.models.Categoria;
import com.chaindrenciales.dashboardrh.services.CategoriaService;

@RestController
@RequestMapping("/dashboard-reclutador") // base URL
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/add-categoria-reclutador")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody CategoriaRequestDTO dto) {
        Categoria categoriaGuardada = categoriaService.guardar(dto);
        return ResponseEntity.ok(categoriaGuardada);
    }
}