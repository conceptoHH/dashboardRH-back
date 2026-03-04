package com.chaindrenciales.dashboardrh.dto;

import java.util.List;
import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;

public class DetalleEvaluadorResponseDTO {

	private Long evaluadorId;
	private String nombreCompleto;
	private String correoElectronico;
	private String telefono; 
	private String puesto;  
	private String estatus;

	// Lista de reclutadores con los que trabaja actualmente [cite: 1581]
	private List<ReclutadorResponseDTO> reclutadoresAsociados;

	private Integer totalExamenesCalificados; // [cite: 1582]

	private List<String> categoriasExpertise; // [cite: 1583]

	public DetalleEvaluadorResponseDTO() {
	}

	// --- Getters ---
	public Long getEvaluadorId() {
		return evaluadorId;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getPuesto() {
		return puesto;
	}

	public String getEstatus() {
		return estatus;
	}

	public List<ReclutadorResponseDTO> getReclutadoresAsociados() {
		return reclutadoresAsociados;
	}

	public Integer getTotalExamenesCalificados() {
		return totalExamenesCalificados;
	}

	public List<String> getCategoriasExpertise() {
		return categoriasExpertise;
	}

	// --- Setters ---
	public void setEvaluadorId(Long evaluadorId) {
		this.evaluadorId = evaluadorId;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public void setReclutadoresAsociados(List<ReclutadorResponseDTO> reclutadoresAsociados) {
		this.reclutadoresAsociados = reclutadoresAsociados;
	}

	public void setTotalExamenesCalificados(Integer totalExamenesCalificados) {
		this.totalExamenesCalificados = totalExamenesCalificados;
	}

	public void setCategoriasExpertise(List<String> categoriasExpertise) {
		this.categoriasExpertise = categoriasExpertise;
	}
}