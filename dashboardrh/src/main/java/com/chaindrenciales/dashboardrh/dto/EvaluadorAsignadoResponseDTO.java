package com.chaindrenciales.dashboardrh.dto;
import java.time.LocalDateTime;
import com.chaindrenciales.dashboardrh.enums.*;

public class EvaluadorAsignadoResponseDTO {

    private Long evaluadorId;
    private String nombreCompleto;
    private String correoElectronico;
    private String puesto;
    private LocalDateTime fechaVinculacion;
    private EstadoVinculoEvaluador estatus; 

	public EvaluadorAsignadoResponseDTO() {
	}

	// Getters
	public Long getEvaluadorId() {
		return evaluadorId;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getPuesto() {
		return puesto;
	}

	public LocalDateTime getFechaVinculacion() {
		return fechaVinculacion;
	}

	public EstadoVinculoEvaluador getEstatus() {
		return estatus;
	}

	// Setters
	public void setEvaluadorId(Long evaluadorId) {
		this.evaluadorId = evaluadorId;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setFechaVinculacion(LocalDateTime fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}

	public void setEstatus(EstadoVinculoEvaluador estatus) {
		this.estatus = estatus;
	}
}