package com.chaindrenciales.dashboardrh.dto;

import jakarta.validation.constraints.NotNull;

public class EstatusEvaluadorRequestDTO {

	@NotNull(message = "El nuevo estatus es obligatorio")
    private  Boolean nuevoEstatus;


	public EstatusEvaluadorRequestDTO() {
	}


	public Boolean getNuevoEstatus() {
		return nuevoEstatus;
	}


	public void setNuevoEstatus(Boolean nuevoEstatus) {
		this.nuevoEstatus = nuevoEstatus;
	}

	
}