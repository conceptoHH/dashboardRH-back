package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.CrearUsuarioDesdeInvitacionRequestDTO;
import com.chaindrenciales.dashboardrh.dto.RegistroUsuarioResponseDTO;
import com.chaindrenciales.dashboardrh.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/desde-invitacion")
    public RegistroUsuarioResponseDTO crearDesdeInvitacion(
            @RequestBody CrearUsuarioDesdeInvitacionRequestDTO dto) {
        return usuarioService.crearDesdeInvitacion(dto);
    }
}
