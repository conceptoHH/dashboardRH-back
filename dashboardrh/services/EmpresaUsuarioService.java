package com.chaindrenciales.dashboardrh.services;

import com.chaindrenciales.dashboardrh.dto.EmpresaUsuarioResponseDTO;
import com.chaindrenciales.dashboardrh.models.RolCorporativo;

public interface EmpresaUsuarioService {

    EmpresaUsuarioResponseDTO asociarUsuarioAEmpresa(
            Long usuarioId,
            Long empresaId,
            RolCorporativo rol
    );

    EmpresaUsuarioResponseDTO crearAdminRh(Long adminId, Long usuarioId, Long empresaId);
}