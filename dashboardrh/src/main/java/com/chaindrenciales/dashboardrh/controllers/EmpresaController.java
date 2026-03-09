package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.EmpresaRequestDTO;
import com.chaindrenciales.dashboardrh.dto.EmpresaResponseDTO;
import com.chaindrenciales.dashboardrh.services.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public EmpresaResponseDTO crearEmpresa(@RequestBody EmpresaRequestDTO dto) {
        return empresaService.crearEmpresa(dto);
    }

    @GetMapping("/{id}")
    public EmpresaResponseDTO obtenerEmpresa(@PathVariable Long id) {
        return empresaService.obtenerPorId(id);
    }
}
