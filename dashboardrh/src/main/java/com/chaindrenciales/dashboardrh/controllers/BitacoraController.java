package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

import com.chaindrenciales.dashboardrh.dto.BitacoraDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.BitacoraResponseDTO;
import com.chaindrenciales.dashboardrh.services.BitacoraRHService;

@RestController
@RequestMapping("/api/dashboard-liderRH/bitacora")
public class BitacoraController {

    private final BitacoraRHService bitacoraService;


    public BitacoraController(BitacoraRHService bitacoraService) {
        this.bitacoraService = bitacoraService;
    }

    // GET /api/dashboard-liderRH/bitacora
    @GetMapping
    public ResponseEntity<Page<BitacoraResponseDTO>> consultarBitacoraRH(
            // El @DateTimeFormat asegura que Spring parsee correctamente "yyyy-MM-dd"
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(required = false) String accion,
            @RequestParam(required = false) Long usuarioId,
            @PageableDefault(size = 20) Pageable pageable,
            Authentication authentication) {
        

        Long empresaIdLogueada = extraerEmpresaId(authentication);


        Page<BitacoraResponseDTO> resultados = bitacoraService.listarBitacora(
                empresaIdLogueada, fechaInicio, fechaFin, accion, usuarioId, pageable);

        return ResponseEntity.ok(resultados);
    }
    

    private Long extraerEmpresaId(Authentication authentication) {
        // Falta lógica del JWT
        return 1L;
    }
    

    // Endpoint para probar el Top 10
    @GetMapping("/top10")
    public List<BitacoraDetalleDTO> obtenerTop10() {
        return bitacoraService.obtenerTop10Bitacora();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}