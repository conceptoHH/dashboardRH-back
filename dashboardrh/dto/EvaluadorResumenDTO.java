package com.chaindrenciales.dashboardrh.dto;
import java.time.LocalDateTime;
import java.util.List;

public class EvaluadorResumenDTO {

	private Long evaluadorId;
    private String nombreCompleto;
    private String puesto;
    private Integer examenesPendientes; 
    private Boolean estado;
    private LocalDateTime fechaAsociacion; 

	public EvaluadorResumenDTO() {
	}
	
	public EvaluadorResumenDTO(Long evaluadorId, String nombre, String apellidos, String puesto,
			Integer examenesPendientes, Boolean activo, LocalDateTime fechaAsociacion) {
		this.evaluadorId = evaluadorId;
		this.nombreCompleto = nombre + " " + apellidos;
		this.puesto = puesto;
		this.examenesPendientes = examenesPendientes;
		this.estado = activo;
		this.fechaAsociacion = fechaAsociacion;
	}

	// Getters
	public Long getEvaluadorId() {
		return evaluadorId;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

    public String getPuesto() {
		return puesto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public LocalDateTime getFechaAsociacion() {
		return fechaAsociacion;
	}


	// Setters
	public void setEvaluadorId(Long evaluadorId) {
		this.evaluadorId = evaluadorId;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public void setFechaAsociacion(LocalDateTime fechaAsociacion) {
		this.fechaAsociacion = fechaAsociacion;
	}
	
	public Integer getExamenesPendientes() {
		return examenesPendientes;
	}

	public void setExamenesPendientes(Integer examenesPendientes) {
		this.examenesPendientes = examenesPendientes;
	}

}