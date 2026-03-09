package com.chaindrenciales.dashboardrh.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaindrenciales.dashboardrh.dto.DashboardRHDTO;
import com.chaindrenciales.dashboardrh.services.DashboardRHService;

@RestController
@RequestMapping("/api/dashboard-liderRH/dashboard")
public class DashboardRHController {

    private final DashboardRHService dashboardService;

    public DashboardRHController(DashboardRHService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/metricas")
    public ResponseEntity<DashboardRHDTO> obtenerMetricasDashboard(Authentication authentication) {
        
        // Obtenemos de forma segura a quién le pertenecen los datos
        Long empresaIdLogueada = extraerEmpresaId(authentication);

        // Llamamos al servicio refactorizado
        DashboardRHDTO metricas = dashboardService.obtenerDashboard(empresaIdLogueada);

        return ResponseEntity.ok(metricas);
    }

    private Long extraerEmpresaId(Authentication authentication) {
        // Mock de obtención del token
        return 1L;
    }
}