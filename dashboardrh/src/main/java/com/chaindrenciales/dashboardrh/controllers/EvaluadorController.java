package com.chaindrenciales.dashboardrh.controllers;
import jakarta.validation.Valid;

import java.util.List;

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
import com.chaindrenciales.dashboardrh.dto.EvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.EmpleadoResumenDTO;
import com.chaindrenciales.dashboardrh.services.DashboardEvaluadorService;
import com.chaindrenciales.dashboardrh.services.EvaluadorService;

@RestController
@RequestMapping("/api/dashboard-liderRH/evaluadores") 
public class EvaluadorController {

    private final EvaluadorService evaluadorService;
    private final DashboardEvaluadorService dashboardEvaluadorService;

    
    public EvaluadorController(
            EvaluadorService evaluadorService,
            DashboardEvaluadorService dashboardEvaluadorService) {

        this.evaluadorService = evaluadorService;
        this.dashboardEvaluadorService = dashboardEvaluadorService;
    }
    


    // Usamos Pageable de Spring en lugar de parámetros manuales page/size
    @GetMapping
    public ResponseEntity<Page<EmpleadoResumenDTO>> listarEvaluadores(
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) String nombre,
            Pageable pageable) {
        
        Page<EmpleadoResumenDTO> evaluadores = evaluadorService.listarEvaluadores(categoriaId, nombre, pageable);
        return ResponseEntity.ok(evaluadores);
    }
    
    @GetMapping("/{idEmpresa}")
    public ResponseEntity<List<EvaluadorResponseDTO>> listarEvaluadoresPorEmpresa(
            @PathVariable Long idEmpresa) {
        List<EvaluadorResponseDTO> evaluadores =
        		dashboardEvaluadorService.obtenerEvaluadoresPorEmpresa(idEmpresa);

        return ResponseEntity.ok(evaluadores);
    }
    
    
    
    
    /*
	// GET /api/dashboard-liderRH/evaluadores/{evaluadorId}/detalle
	@GetMapping("/{evaluadorId}/detalle") 
	public ResponseEntity<DetalleEvaluadorResponseDTO> obtenerDetalleEvaluador(@PathVariable Long evaluadorId,
			Authentication authentication) {

		Long empresaIdLogueada = extraerEmpresaId(authentication);

		DetalleEvaluadorResponseDTO detalle = dashboardEvaluadorService.obtenerDetalleEvaluador(evaluadorId, empresaIdLogueada);

		return ResponseEntity.ok(detalle);
	}
*/
    

	// GET /api/dashboard-liderRH/evaluadores/{evaluadorId}/detalle
	@GetMapping("/{evaluadorId}/detalle") 
	public ResponseEntity<DetalleEvaluadorResponseDTO> obtenerDetalleEvaluador(@PathVariable Long evaluadorId,
			Authentication authentication) {

		//Long empresaIdLogueada = extraerEmpresaId(authentication);

		   // Forzar empresaId = 9
	   Long empresaIdLogueada = 9L;
	    
		
		DetalleEvaluadorResponseDTO detalle = dashboardEvaluadorService.obtenerDetalleEvaluador(evaluadorId, empresaIdLogueada);

		return ResponseEntity.ok(detalle);
	}
	
	
    // POST /api/dashboard-liderRH/evaluadores 
    @PostMapping
    public ResponseEntity<EvaluadorDetalleDTO> registrarEvaluador(@Valid @RequestBody EvaluadorRegistroRequestDTO request) {
        
        EvaluadorDetalleDTO respuesta = evaluadorService.registrarEvaluador(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta); 
    }
/*
    // PUT /api/dashboard-liderRH/evaluadores/{evaluadorId}/estatus 
    @PutMapping("/{evaluadorId}/estatus")
    public ResponseEntity<Void> actualizarEstatusEvaluador(@PathVariable Long evaluadorId,
    		@Valid @RequestBody EstatusEvaluadorRequestDTO request) {
        
        evaluadorService.actualizarEstatus(evaluadorId, request.getNuevoEstatus());
        return ResponseEntity.noContent().build();
    }
  */
    
    @PutMapping("/{evaluadorId}/estatus")
    public ResponseEntity<Void> actualizarEstatusEvaluador(
            @PathVariable Long evaluadorId,
            @RequestBody EstatusEvaluadorRequestDTO request) {

        dashboardEvaluadorService.actualizarEstatus(
                evaluadorId,
                request.getNuevoEstatus()
        );

        return ResponseEntity.noContent().build();
    }
    private Long extraerEmpresaId(Authentication authentication) {
        // Mock de obtención del token
        return 1L;
    }
}