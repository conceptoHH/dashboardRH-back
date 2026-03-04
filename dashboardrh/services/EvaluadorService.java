package com.chaindrenciales.dashboardrh.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chaindrenciales.dashboardrh.dto.DetalleEvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorRegistroRequestDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorResumenDTO;

import jakarta.validation.Valid;

@Service
public class EvaluadorService {

	public Page<EvaluadorResumenDTO> listarEvaluadores(Long categoriaId, String nombre, Pageable pageable) {
		return null;
	}

	public EvaluadorDetalleDTO registrarEvaluador(@Valid EvaluadorRegistroRequestDTO request) {
		return null;
	}

	public void actualizarEstatus(Long evaluadorId, String nuevoEstatus) {
		
	}

	public DetalleEvaluadorResponseDTO obtenerDetalleEvaluador(Long evaluadorId, Long empresaIdLogueada) {
		return null;
	}
	
	

}
	