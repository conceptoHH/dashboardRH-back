package com.chaindrenciales.dashboardrh.services;

import com.chaindrenciales.dashboardrh.dto.CrearUsuarioDesdeInvitacionRequestDTO;
import com.chaindrenciales.dashboardrh.dto.RegistroUsuarioResponseDTO;

public interface UsuarioService {

    RegistroUsuarioResponseDTO crearDesdeInvitacion(CrearUsuarioDesdeInvitacionRequestDTO dto);
}
