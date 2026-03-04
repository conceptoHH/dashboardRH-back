package com.chaindrenciales.dashboardrh.controllers;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.ReasignacionCargaRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReasignacionCargaResponseDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;
import com.chaindrenciales.dashboardrh.services.ReclutadorService;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard-liderRH/reclutadores")
public class ReclutadorController {

    private final ReclutadorService reclutadorService;

    public ReclutadorController(ReclutadorService reclutadorService) {
        this.reclutadorService = reclutadorService;
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<List<ReclutadorResponseDTO>> listarReclutadoresPorEmpresa(@PathVariable Long idEmpresa) {
        List<ReclutadorResponseDTO> reclutadores = reclutadorService.obtenerReclutadoresPorEmpresa(idEmpresa);
        return ResponseEntity.ok(reclutadores); 
    }
	// GET /api/dashboard-liderRH/reclutadores/{reclutadorId}/detalle
	@GetMapping("/{reclutadorId}/detalle") 
	public ResponseEntity<ReclutadorDetalleDTO> obtenerDetalleReclutador(@PathVariable Long reclutadorId,
			Authentication authentication) {

		Long empresaIdLogueada = extraerEmpresaId(authentication);

		// obtenerDetalleReclutador(Long reclutadorId, Long empresaIdLogueada)
		ReclutadorDetalleDTO detalle = reclutadorService.obtenerDetalleReclutador(reclutadorId, empresaIdLogueada);

		return ResponseEntity.ok(detalle);
	}

	// POST /api/dashboard-liderRH/reclutadores/reasignacion-carga
	@PostMapping("/reasignacion-carga") //
	public ResponseEntity<ReasignacionCargaResponseDTO> reasignarCargaTrabajo(
			@Valid @RequestBody ReasignacionCargaRequestDTO request, Authentication authentication) {

		Long empresaIdLogueada = extraerEmpresaId(authentication);


		if (request.getReclutadorOrigenId().equals(request.getReclutadorDestinoId())) {
			return ResponseEntity.badRequest().build();
		}

		ReasignacionCargaResponseDTO respuesta = reclutadorService.reasignarCarga(request, empresaIdLogueada);

		return ResponseEntity.ok(respuesta);
	}

//     PATCH /api/dashboard-liderRH/reclutadores/
    @PatchMapping("/{reclutadorId}")
    public ResponseEntity<ReclutadorResponseDTO> actualizarReclutador(
            @PathVariable Long reclutadorId,
            @Valid @RequestBody ReclutadorRequestDTO request, Authentication authentication) {
        
    	Long empresaIdLogueada = extraerEmpresaId(authentication);
    	
        ReclutadorResponseDTO reclutadorActualizado = reclutadorService.actualizarReclutador(reclutadorId, request, empresaIdLogueada);
        return ResponseEntity.ok(reclutadorActualizado);
    }
    
    private Long extraerEmpresaId(Authentication authentication) {
        // Mock de obtención del token
        return 9L; //<--- Se refiere a la empresa con id 09 en la bd
    }
}
