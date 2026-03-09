package com.chaindrenciales.dashboardrh.services;

import com.chaindrenciales.dashboardrh.dto.InvitacionEmpresaResponseDTO;
import com.chaindrenciales.dashboardrh.models.RolCorporativo;

public interface InvitacionEmpresaService {

    InvitacionEmpresaResponseDTO crearInvitacion(
            String nombre,
            String email,
            Long empresaId,
            RolCorporativo rol
    );

    InvitacionEmpresaResponseDTO obtenerPorId(Long id);

    InvitacionEmpresaResponseDTO aceptarInvitacion(Long id);

    InvitacionEmpresaResponseDTO crearInvitacionHrAdmin(Long adminId, String nombre, String email, Long empresaId);
}