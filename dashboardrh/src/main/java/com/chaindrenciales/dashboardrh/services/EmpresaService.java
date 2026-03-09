package com.chaindrenciales.dashboardrh.services;

import com.chaindrenciales.dashboardrh.dto.EmpresaRequestDTO;
import com.chaindrenciales.dashboardrh.dto.EmpresaResponseDTO;

public interface EmpresaService {

    EmpresaResponseDTO crearEmpresa(EmpresaRequestDTO dto);

    EmpresaResponseDTO obtenerPorId(Long id);
}