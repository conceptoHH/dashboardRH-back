package com.chaindrenciales.dashboardrh.dto;

public class EvaluadorReclutadorDTO {
	private Long reclutadorId;
	private String reclutadorNombre;
	private Long evaluadorId;
	private String evaluadorNombre;

	public EvaluadorReclutadorDTO() {
	}

	public Long getReclutadorId() {
		return reclutadorId;
	}

	public void setReclutadorId(Long reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

	public String getReclutadorNombre() {
		return reclutadorNombre;
	}

	public void setReclutadorNombre(String reclutadorNombre) {
		this.reclutadorNombre = reclutadorNombre;
	}

	public Long getEvaluadorId() {
		return evaluadorId;
	}

	public void setEvaluadorId(Long evaluadorId) {
		this.evaluadorId = evaluadorId;
	}

	public String getEvaluadorNombre() {
		return evaluadorNombre;
	}

	public void setEvaluadorNombre(String evaluadorNombre) {
		this.evaluadorNombre = evaluadorNombre;
	}
}