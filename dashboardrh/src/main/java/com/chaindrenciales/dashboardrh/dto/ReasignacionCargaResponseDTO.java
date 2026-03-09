package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;

public class ReasignacionCargaResponseDTO {

	private Long reclutadorOrigenId;
	private Long reclutadorDestinoId;
	private String motivoReasignacion; 
	private LocalDateTime fechaReasignacion;

	public ReasignacionCargaResponseDTO() {
	}

	public Long getReclutadorOrigenId() {
		return reclutadorOrigenId;
	}

	public Long getReclutadorDestinoId() {
		return reclutadorDestinoId;
	}

	public String getMotivoReasignacion() {
		return motivoReasignacion;
	}

	public LocalDateTime getFechaReasignacion() {
		return fechaReasignacion;
	}

	public void setReclutadorOrigenId(Long reclutadorOrigenId) {
		this.reclutadorOrigenId = reclutadorOrigenId;
	}

	public void setReclutadorDestinoId(Long reclutadorDestinoId) {
		this.reclutadorDestinoId = reclutadorDestinoId;
	}

	public void setMotivoReasignacion(String motivoReasignacion) {
		this.motivoReasignacion = motivoReasignacion;
	}

	public void setFechaReasignacion(LocalDateTime fechaReasignacion) {
		this.fechaReasignacion = fechaReasignacion;
	}

}
