package com.chaindrenciales.dashboardrh.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReasignacionCargaRequestDTO {

	@NotNull(message = "El ID del reclutador origen es obligatorio")
	private Long reclutadorOrigenId;

	@NotNull(message = "El ID del reclutador destino es obligatorio")
	private Long reclutadorDestinoId;

	private String motivoReasignacion;

	public ReasignacionCargaRequestDTO() {
	}

	// --- Getters ---
	public Long getReclutadorOrigenId() {
		return reclutadorOrigenId;
	}

	public Long getReclutadorDestinoId() {
		return reclutadorDestinoId;
	}

	public String getMotivoReasignacion() {
		return motivoReasignacion;
	}

	// --- Setters ---
	public void setReclutadorOrigenId(Long reclutadorOrigenId) {
		this.reclutadorOrigenId = reclutadorOrigenId;
	}

	public void setReclutadorDestinoId(Long reclutadorDestinoId) {
		this.reclutadorDestinoId = reclutadorDestinoId;
	}

	public void setMotivoReasignacion(String motivoReasignacion) {
		this.motivoReasignacion = motivoReasignacion;
	}
}
