package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;

public class EvaluadorResponseDTO {
    private Long evaluadorId;
    private String nombre;
    private String apellidos;
    private String puesto;
    private Integer cargaDeTrabajo;
    private Boolean estado;
    private String actividadReciente;

    public EvaluadorResponseDTO(Long evaluadorId,
                                 String nombre,
                                 String apellidos,
                                 String puesto,
                                 Integer cargaDeTrabajo,
                                 Boolean estado,
                                 String actividadReciente) {
        this.evaluadorId = evaluadorId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.cargaDeTrabajo = cargaDeTrabajo;
        this.estado = estado;
        this.actividadReciente = actividadReciente;
    }

    public EvaluadorResponseDTO() {}

	public Long getEvaluadorId() {
		return evaluadorId;
	}

	public void setEvaluadorId(Long evaluadorId) {
		this.evaluadorId = evaluadorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Integer getCargaDeTrabajo() {
		return cargaDeTrabajo;
	}

	public void setCargaDeTrabajo(Integer cargaDeTrabajo) {
		this.cargaDeTrabajo = cargaDeTrabajo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getActividadReciente() {
		return actividadReciente;
	}

	public void setActividadReciente(String actividadReciente) {
		this.actividadReciente = actividadReciente;
	}

    
    
}
