package com.chaindrenciales.dashboardrh.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.BitacoraDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.DashboardRHDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorReclutadorDTO;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.BitacoraDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.DashboardRHDTO;

@Service
@Transactional(readOnly = true) // true porque el dashboard solo lee datos
public class DashboardRHService {

    // Agregamos el parámetro empresaId crucial para la seguridad de datos
    public DashboardRHDTO obtenerDashboard(Long empresaId) {
        
        DashboardRHDTO dashboard = new DashboardRHDTO();

        
        dashboard.setTotalReclutadoresActivos(0L); // Mock
        dashboard.setTotalEvaluadoresRegistrados(0L); // Mock
        dashboard.setTotalAsociaciones(0L); // Mock
        dashboard.setPorcentajeActividad(0.0); // Mock

        // consulta a la tabla de bitácora limitando a los últimos 5 registros por empresaId
        List<BitacoraDetalleDTO> actividades = List.of(); 
        dashboard.setActividadesRecientes(actividades);

        return dashboard;
    }
}