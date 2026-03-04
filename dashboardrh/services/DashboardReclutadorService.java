package com.chaindrenciales.dashboardrh.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.BitacoraDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorResumenDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;

import jakarta.validation.Valid;

@Service
@Transactional
public class DashboardReclutadorService {

	public List<ReclutadorResponseDTO> obtenerReclutadoresPorEmpresa(Long empresaId) {
		return List.of();
	}
/*
	public ReclutadorResponseDTO registrarReclutador(@Valid ReclutadorRequestDTO request) {
		return new ReclutadorResponseDTO();
	}

	public ReclutadorResponseDTO actualizarReclutador(Long reclutadorId, @Valid ReclutadorRequestDTO request) {
		return new ReclutadorResponseDTO();
	}*/

	public ReclutadorDetalleDTO obtenerDetalleReclutador(Long reclutadorId) {
		ReclutadorDetalleDTO detalle = new ReclutadorDetalleDTO();

		List<EvaluadorResumenDTO> evaluadores = List.of();
		detalle.setEvaluadores(evaluadores);

//		List<BitacoraDetalleDTO> actividades = List.of();
//		detalle.setActividades(actividades);

		return detalle;
	}
}