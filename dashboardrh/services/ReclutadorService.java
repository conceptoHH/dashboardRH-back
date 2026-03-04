 package com.chaindrenciales.dashboardrh.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chaindrenciales.dashboardrh.dto.ReasignacionCargaRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReasignacionCargaResponseDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;
import com.chaindrenciales.dashboardrh.repositories.ReclutadorRepository;

import jakarta.validation.Valid;

@Service
public interface ReclutadorService {

	List<ReclutadorResponseDTO> obtenerReclutadoresPorEmpresa(Long idEmpresa);

    ReclutadorResponseDTO actualizarReclutador(Long reclutadorId, @Valid ReclutadorRequestDTO request, Long empresaIdLogeada);

    ReclutadorDetalleDTO obtenerDetalleReclutador(Long reclutadorId, Long empresaIdLogueada);

    ReasignacionCargaResponseDTO reasignarCarga(@Valid ReasignacionCargaRequestDTO request, Long empresaIdLogueada);

}
