package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;

public class BitacoraResponseDTO {

	private Long bitacoraId;
	private String nombreUsuario;
	private String accion;
	private String descripcion;
	private LocalDateTime fechaAccion;
	private Long empresaId;

	public Long getBitacoraId() {
		return bitacoraId;
	}

	public void setBitacoraId(Long bitacoraId) {
		this.bitacoraId = bitacoraId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaAccion() {
		return fechaAccion;
	}

	public void setFechaAccion(LocalDateTime fechaAccion) {
		this.fechaAccion = fechaAccion;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

}
