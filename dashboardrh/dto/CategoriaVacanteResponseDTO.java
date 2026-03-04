package com.chaindrenciales.dashboardrh.dto;

public class CategoriaVacanteResponseDTO {

	private Long categoriaId;
	private String cargo;
	private String descripcionPuesto;
	private String tecnologiaPrincipal;
	private String nivelExperiencia;
	private String estado;

	public CategoriaVacanteResponseDTO() {
	}


	public Long getCategoriaId() {
		return categoriaId;
	}

	public String getCargo() {
		return cargo;
	}

	public String getDescripcionPuesto() {
		return descripcionPuesto;
	}

	public String getTecnologiaPrincipal() {
		return tecnologiaPrincipal;
	}

	public String getNivelExperiencia() {
		return nivelExperiencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setDescripcionPuesto(String descripcionPuesto) {
		this.descripcionPuesto = descripcionPuesto;
	}

	public void setTecnologiaPrincipal(String tecnologiaPrincipal) {
		this.tecnologiaPrincipal = tecnologiaPrincipal;
	}

	public void setNivelExperiencia(String nivelExperiencia) {
		this.nivelExperiencia = nivelExperiencia;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}