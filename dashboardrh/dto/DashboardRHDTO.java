package com.chaindrenciales.dashboardrh.dto;
import java.util.List;

public class DashboardRHDTO {

    // Cambiamos a Long para compatibilidad con JPA
    private Long totalReclutadoresActivos;
    private Long totalEvaluadoresRegistrados;
    private Long totalAsociaciones; // Se reemplaza el dto EvaluadorReclutador para no mandar una lista pesada
    private Double porcentajeActividad;

    private List<BitacoraDetalleDTO> actividadesRecientes;

    public DashboardRHDTO() {
    }

    // Getters
    public Long getTotalReclutadoresActivos() {
        return totalReclutadoresActivos;
    }

    public Long getTotalEvaluadoresRegistrados() {
        return totalEvaluadoresRegistrados;
    }

    public Long getTotalAsociaciones() {
        return totalAsociaciones;
    }

    public Double getPorcentajeActividad() {
        return porcentajeActividad;
    }

    public List<BitacoraDetalleDTO> getActividadesRecientes() {
        return actividadesRecientes;
    }

    // Setters
    public void setTotalReclutadoresActivos(Long totalReclutadoresActivos) {
        this.totalReclutadoresActivos = totalReclutadoresActivos;
    }

    public void setTotalEvaluadoresRegistrados(Long totalEvaluadoresRegistrados) {
        this.totalEvaluadoresRegistrados = totalEvaluadoresRegistrados;
    }

    public void setTotalAsociaciones(Long totalAsociaciones) {
        this.totalAsociaciones = totalAsociaciones;
    }

    public void setPorcentajeActividad(Double porcentajeActividad) {
        this.porcentajeActividad = porcentajeActividad;
    }

    public void setActividadesRecientes(List<BitacoraDetalleDTO> actividadesRecientes) {
        this.actividadesRecientes = actividadesRecientes;
    }
}