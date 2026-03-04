/*package com.chaindrenciales.dashboardrh.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.EvaluadorAsignadoResponseDTO;
import com.chaindrenciales.dashboardrh.dto.VinculacionRequestDTO;
import com.chaindrenciales.dashboardrh.dto.VinculacionResponseDTO;
import com.chaindrenciales.dashboardrh.services.ReclutadorEvaluadorService;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard-liderRH/reclutador-evaluador")
public class ReclutadorEvaluadorController2{

    private final ReclutadorEvaluadorService vinculacionService;

	public ReclutadorEvaluadorController2(ReclutadorEvaluadorService vinculacionService) {
		this.vinculacionService = vinculacionService;
	}

	// GET /api/dashboard-liderRH/reclutador-evaluador/{reclutadorId}
	@GetMapping("/{reclutadorId}")
	public ResponseEntity<List<EvaluadorAsignadoResponseDTO>> obtenerEvaluadoresVinculados(
			@PathVariable Long reclutadorId) {

		List<EvaluadorAsignadoResponseDTO> evaluadores = vinculacionService
				.obtenerEvaluadoresPorReclutador(reclutadorId);
		return ResponseEntity.ok(evaluadores);
	}

	// POST /api/dashboard-liderRH/reclutador-evaluador/vinculacion
	@PostMapping("/vinculacion")
	public ResponseEntity<List<VinculacionResponseDTO>> vincularEvaluadores(
			@Valid @RequestBody VinculacionRequestDTO request) {

		// Retornamos una lista porque el request puede contener N evaluadores
		List<VinculacionResponseDTO> vinculaciones = vinculacionService.vincularEvaluadores(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(vinculaciones);
	}
	

}
*/