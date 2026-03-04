package com.chaindrenciales.dashboardrh.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.chaindrenciales.dashboardrh.enums.*;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AsignacionExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime fechaAsignacion;

	private LocalDateTime fechaEvaluacion;

	private String comentarios;

	@Enumerated(EnumType.STRING)
	private EstadoAsignacion estado = EstadoAsignacion.ASIGNADO;

	private String uuid;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnoreProperties({ "password", "hashBlockchain", "username", "accountNonExpired", "accountNonLocked",
			"credentialsNonExpired" })
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "reclutador_id")
	@JsonIgnoreProperties({ "password", "hashBlockchain", "username", "accountNonExpired", "accountNonLocked",
			"credentialsNonExpired" })
	private Usuario reclutador;

	@ManyToOne
	@JoinColumn(name = "evaluador_id")
	@JsonIgnoreProperties({ "password", "hashBlockchain", "username", "accountNonExpired", "accountNonLocked",
			"credentialsNonExpired" })
	private Usuario evaluador;

	@ManyToOne
	@JoinColumn(name = "examen_id")
	@JsonIgnoreProperties({ "categoria", "activo" })
	private Examen examen;

	@Column(length = 500)
	private String motivoCancelacion;

	private LocalDateTime fechaLimite;

	// === Constructores ===

	public AsignacionExamen() {
		super();
	}

	public AsignacionExamen(Long id, LocalDateTime fechaAsignacion, LocalDateTime fechaEvaluacion, String comentarios,
			EstadoAsignacion estado, String uuid, Usuario usuario, Usuario reclutador, Usuario evaluador, Examen examen,
			String motivoCancelacion) {
		this.id = id;
		this.fechaAsignacion = fechaAsignacion;
		this.fechaEvaluacion = fechaEvaluacion;
		this.comentarios = comentarios;
		this.estado = estado;
		this.uuid = uuid;
		this.usuario = usuario;
		this.reclutador = reclutador;
		this.evaluador = evaluador;
		this.examen = examen;
		this.motivoCancelacion = motivoCancelacion;
	}

	public AsignacionExamen(Long id, LocalDateTime fechaAsignacion, LocalDateTime fechaEvaluacion, String comentarios,
			EstadoAsignacion estado, String uuid, Usuario usuario, Usuario reclutador, Usuario evaluador, Examen examen,
			String motivoCancelacion, LocalDateTime fechaLimite) {
		super();
		this.id = id;
		this.fechaAsignacion = fechaAsignacion;
		this.fechaEvaluacion = fechaEvaluacion;
		this.comentarios = comentarios;
		this.estado = estado;
		this.uuid = uuid;
		this.usuario = usuario;
		this.reclutador = reclutador;
		this.evaluador = evaluador;
		this.examen = examen;
		this.motivoCancelacion = motivoCancelacion;
		this.fechaLimite = fechaLimite;
	}

	// === Getters y Setters ===

	public LocalDateTime getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDateTime fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public LocalDateTime getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public EstadoAsignacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoAsignacion estado) {
		this.estado = estado;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getReclutador() {
		return reclutador;
	}

	public void setReclutador(Usuario reclutador) {
		this.reclutador = reclutador;
	}

	public Usuario getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(Usuario evaluador) {
		this.evaluador = evaluador;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}
}
