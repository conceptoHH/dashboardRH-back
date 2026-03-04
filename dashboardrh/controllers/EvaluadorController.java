package com.chaindrenciales.dashboardrh.controllers;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.chaindrenciales.dashboardrh.dto.DetalleEvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.EstatusEvaluadorRequestDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorRegistroRequestDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorResumenDTO;
import com.chaindrenciales.dashboardrh.services.EvaluadorService;

@RestController
@RequestMapping("/api/dashboard-liderRH/evaluadores") 
public class EvaluadorController {

    private final EvaluadorService evaluadorService;

    public EvaluadorController(EvaluadorService evaluadorService) {
        this.evaluadorService = evaluadorService;
    }

 
    // Usamos Pageable de Spring en lugar de parámetros manuales page/size
    @GetMapping
    public ResponseEntity<Page<EvaluadorResumenDTO>> listarEvaluadores(
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) String nombre,
            Pageable pageable) {
        
        Page<EvaluadorResumenDTO> evaluadores = evaluadorService.listarEvaluadores(categoriaId, nombre, pageable);
        return ResponseEntity.ok(evaluadores);
    }
    
	// GET /api/dashboard-liderRH/evaluadores/{evaluadorId}/detalle
	@GetMapping("/{evaluadorId}/detalle") // Endpoint según doc [cite: 1558]
	public ResponseEntity<DetalleEvaluadorResponseDTO> obtenerDetalleEvaluador(@PathVariable Long evaluadorId,
			Authentication authentication) {

		Long empresaIdLogueada = extraerEmpresaId(authentication);

		DetalleEvaluadorResponseDTO detalle = evaluadorService.obtenerDetalleEvaluador(evaluadorId, empresaIdLogueada);

		return ResponseEntity.ok(detalle);
	}

    // POST /api/dashboard-liderRH/evaluadores 
    @PostMapping
    public ResponseEntity<EvaluadorDetalleDTO> registrarEvaluador(@Valid @RequestBody EvaluadorRegistroRequestDTO request) {
        
        EvaluadorDetalleDTO respuesta = evaluadorService.registrarEvaluador(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta); 
    }

    // PUT /api/dashboard-liderRH/evaluadores/{evaluadorId}/estatus 
    @PutMapping("/{evaluadorId}/estatus")
    public ResponseEntity<Void> actualizarEstatusEvaluador(@PathVariable Long evaluadorId,
    		@Valid @RequestBody EstatusEvaluadorRequestDTO request) {
        
        evaluadorService.actualizarEstatus(evaluadorId, request.getNuevoEstatus());
        return ResponseEntity.noContent().build();
    }
    
    private Long extraerEmpresaId(Authentication authentication) {
        // Mock de obtención del token
        return 1L;
    }
}