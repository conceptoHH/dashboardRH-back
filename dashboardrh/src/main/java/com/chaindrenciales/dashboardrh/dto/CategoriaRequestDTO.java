package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;

public class CategoriaRequestDTO {

	private Long reclutadorId;
	private String beneficios;
	private String cargo;
	private String descripcionPuesto;
	private String estado;
	private LocalDateTime fecha_publicacion;
	private String frecuencia_pago;
	private String moneda;
	private String nivel_experiencia;
	private String requisitos;
	private Double sueldo_maximo;
	private Double sueldo_minimo;
	private String tipo_empleo;
	private String tipo_lugar_trabajo;
	private String ubicacion;
	private String ambito_laboral;
	private Boolean dispuesto_reubicacion;
	private String tecnologia_principal;
	private String idiomas;
	private String tecnologias_secundarias;

	public Long getReclutadorId() {
		return reclutadorId;
	}

	public void setReclutadorId(Long reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcionPuesto() {
		return descripcionPuesto;
	}

	public void setDescripcionPuesto(String descripcionPuesto) {
		this.descripcionPuesto = descripcionPuesto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDateTime getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(LocalDateTime fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getFrecuencia_pago() {
		return frecuencia_pago;
	}

	public void setFrecuencia_pago(String frecuencia_pago) {
		this.frecuencia_pago = frecuencia_pago;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getNivel_experiencia() {
		return nivel_experiencia;
	}

	public void setNivel_experiencia(String nivel_experiencia) {
		this.nivel_experiencia = nivel_experiencia;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Double getSueldo_maximo() {
		return sueldo_maximo;
	}

	public void setSueldo_maximo(Double sueldo_maximo) {
		this.sueldo_maximo = sueldo_maximo;
	}

	public Double getSueldo_minimo() {
		return sueldo_minimo;
	}

	public void setSueldo_minimo(Double sueldo_minimo) {
		this.sueldo_minimo = sueldo_minimo;
	}

	public String getTipo_empleo() {
		return tipo_empleo;
	}

	public void setTipo_empleo(String tipo_empleo) {
		this.tipo_empleo = tipo_empleo;
	}

	public String getTipo_lugar_trabajo() {
		return tipo_lugar_trabajo;
	}

	public void setTipo_lugar_trabajo(String tipo_lugar_trabajo) {
		this.tipo_lugar_trabajo = tipo_lugar_trabajo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getAmbito_laboral() {
		return ambito_laboral;
	}

	public void setAmbito_laboral(String ambito_laboral) {
		this.ambito_laboral = ambito_laboral;
	}

	public Boolean getDispuesto_reubicacion() {
		return dispuesto_reubicacion;
	}

	public void setDispuesto_reubicacion(Boolean dispuesto_reubicacion) {
		this.dispuesto_reubicacion = dispuesto_reubicacion;
	}

	public String getTecnologia_principal() {
		return tecnologia_principal;
	}

	public void setTecnologia_principal(String tecnologia_principal) {
		this.tecnologia_principal = tecnologia_principal;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getTecnologias_secundarias() {
		return tecnologias_secundarias;
	}

	public void setTecnologias_secundarias(String tecnologias_secundarias) {
		this.tecnologias_secundarias = tecnologias_secundarias;
	}

}
