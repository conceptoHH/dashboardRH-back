package com.chaindrenciales.dashboardrh.services;

import java.util.List;

import com.chaindrenciales.dashboardrh.dto.DetalleEvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorResponseDTO;

public interface DashboardEvaluadorService {
	List<EvaluadorResponseDTO> obtenerEvaluadoresPorEmpresa(Long idEmpresa);
	
DetalleEvaluadorResponseDTO obtenerDetalleEvaluador(Long evaluadorId, Long empresaId); // <--- obtiene el detalle de los evaluadores 


void actualizarEstatus(Long evaluadorId, Boolean nuevoEstatus);
}
