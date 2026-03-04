package com.chaindrenciales.dashboardrh.dto;
import java.time.LocalDateTime;

public class EvaluadorDetalleDTO {

    private Long evaluadorId; 
    private LocalDateTime fechaRegistro; 
    private String mensaje; 

	public EvaluadorDetalleDTO() {
	}

	// Getters
	public Long getEvaluadorId() {
		return evaluadorId;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public String getMensaje() {
		return mensaje;
	}

	// Setters
	public void setEvaluadorId(Long evaluadorId) {
		this.evaluadorId = evaluadorId;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
