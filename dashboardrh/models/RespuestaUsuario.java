package com.chaindrenciales.dashboardrh.models;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

@Entity
public class RespuestaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String respuestaDada;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Pregunta pregunta;

    @ManyToOne
    private Examen examen;

    @ManyToOne
    private AsignacionExamen asignacion;

    private LocalDateTime fechaRespuesta;

	public RespuestaUsuario(Long id, String respuestaDada, Usuario usuario, Pregunta pregunta, Examen examen,
			AsignacionExamen asignacion, LocalDateTime fechaRespuesta) {
		super();
		this.id = id;
		this.respuestaDada = respuestaDada;
		this.usuario = usuario;
		this.pregunta = pregunta;
		this.examen = examen;
		this.asignacion = asignacion;
		this.fechaRespuesta = fechaRespuesta;
	}

	public RespuestaUsuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRespuestaDada() {
		return respuestaDada;
	}

	public void setRespuestaDada(String respuestaDada) {
		this.respuestaDada = respuestaDada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public AsignacionExamen getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(AsignacionExamen asignacion) {
		this.asignacion = asignacion;
	}

	public LocalDateTime getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
    
}