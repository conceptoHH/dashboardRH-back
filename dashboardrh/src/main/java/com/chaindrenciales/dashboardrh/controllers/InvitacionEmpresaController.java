package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.InvitacionEmpresaResponseDTO;
import com.chaindrenciales.dashboardrh.models.RolCorporativo;
import com.chaindrenciales.dashboardrh.services.InvitacionEmpresaService;

@RestController
@RequestMapping("/invitaciones")
public class InvitacionEmpresaController {

    private final InvitacionEmpresaService service;

    public InvitacionEmpresaController(InvitacionEmpresaService service) {
        this.service = service;
    }

    @PostMapping
    public InvitacionEmpresaResponseDTO crearInvitacion(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam Long empresaId,
            @RequestParam RolCorporativo rol
    ) {
        return service.crearInvitacion(nombre, email, empresaId, rol);
    }

    @GetMapping("/{id}")
    public InvitacionEmpresaResponseDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PatchMapping("/{id}/aceptar")
    public InvitacionEmpresaResponseDTO aceptar(@PathVariable Long id) {
        return service.aceptarInvitacion(id);
    }

    @PostMapping("/admin-rh")
    public InvitacionEmpresaResponseDTO invitarHrAdmin(
            @RequestParam Long adminId,
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam Long empresaId
    ) {
        return service.crearInvitacionHrAdmin(adminId, nombre, email, empresaId);
    }
}