package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.EmpresaUsuarioRequestDTO;
import com.chaindrenciales.dashboardrh.dto.EmpresaUsuarioResponseDTO;
import com.chaindrenciales.dashboardrh.services.EmpresaUsuarioService;

@RestController
@RequestMapping("/empresa-usuarios")
public class EmpresaUsuarioController {

    private final EmpresaUsuarioService service;

    public EmpresaUsuarioController(EmpresaUsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public EmpresaUsuarioResponseDTO asociar(@RequestBody EmpresaUsuarioRequestDTO request) {
        return service.asociarUsuarioAEmpresa(
                request.getUsuarioId(),
                request.getEmpresaId(),
                request.getRol()
        );
    }

}
