package com.chaindrenciales.dashboardrh.dto;
import java.time.LocalDateTime;
import com.chaindrenciales.dashboardrh.enums.EstadoVinculoEvaluador;

public class VinculacionResponseDTO {

    private Long vinculacionId;
    private Long reclutadorId;
    private Long evaluadorId;
    private LocalDateTime fechaVinculacion;
    private EstadoVinculoEvaluador estatus;

    public VinculacionResponseDTO() {}

	// Getters
	public Long getVinculacionId() {
		return vinculacionId;
	}

	public Long getReclutadorId() {
		return reclutadorId;
	}

	public Long getEvaluadorId() {
		return evaluadorId;
	}

	public LocalDateTime getFechaVinculacion() {
		return fechaVinculacion;
	}

	public EstadoVinculoEvaluador getEstatus() {
		return estatus;
	}

	// Setters
	public void setVinculacionId(Long vinculacionId) {
		this.vinculacionId = vinculacionId;
	}

	public void setReclutadorId(Long reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

	public void setEvaluadorId(Long evaluadorId) {
		this.evaluadorId = evaluadorId;
	}

	public void setFechaVinculacion(LocalDateTime fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}

	public void setEstatus(EstadoVinculoEvaluador estatus) {
		this.estatus = estatus;
	}
}