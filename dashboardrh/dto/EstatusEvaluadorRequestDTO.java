package com.chaindrenciales.dashboardrh.dto;

import jakarta.validation.constraints.NotBlank;

public class EstatusEvaluadorRequestDTO {

    @NotBlank(message = "El nuevo estatus es obligatorio")
    private String nuevoEstatus; //

	public EstatusEvaluadorRequestDTO() {
	}

	public String getNuevoEstatus() {
		return nuevoEstatus;
	}

	public void setNuevoEstatus(String nuevoEstatus) {
		this.nuevoEstatus = nuevoEstatus;
	}
}