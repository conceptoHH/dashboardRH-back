package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ReclutadorDetalleDTO {
	
	private Long reclutadorId;
    private String nombreCompleto;
    private String apellidos;
	private String puesto;
    private Boolean estado; 
    private String correoElectronico;
    private Integer candidatosPendientes;

	private List<EvaluadorResumenDTO> evaluadores;
	
	public ReclutadorDetalleDTO() { }
	
	public ReclutadorDetalleDTO(Long reclutadorId, String apellidos, String nombreCompleto, String puesto, Boolean estado,
			String correoElectronico, Integer candidatosPendientes) {
		super();
		this.reclutadorId = reclutadorId;
		this.nombreCompleto = nombreCompleto;
		this.apellidos = apellidos;
		this.puesto = puesto;
		this.estado = estado;
		this.correoElectronico = correoElectronico;
		this.candidatosPendientes = candidatosPendientes;
	}
	
	public Long getReclutadorId() {
		return reclutadorId;
	}

	public void setReclutadorId(Long reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Integer getCandidatosPendientes() {
		return candidatosPendientes;
	}

	public void setCandidatosPendientes(Integer candidatosPendientes) {
		this.candidatosPendientes = candidatosPendientes;
	}
	
    public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<EvaluadorResumenDTO> getEvaluadores() {
		return evaluadores;
	}

	public void setEvaluadores(List<EvaluadorResumenDTO> evaluadores) {
		this.evaluadores = evaluadores;
	}


}
