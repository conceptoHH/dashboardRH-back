package com.chaindrenciales.dashboardrh.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "configuracion_examen")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ConfiguracionExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "configuracion_id")
	private Long id;

	@Column(name = "camara", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean camara;

	@Column(name = "microfono", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean microfono;

	@Column(name = "max_cambio_pesta")
	private Integer maxCambioPestana;

	@Column(name = "toleran_desconexion")
	private Integer toleranDesconexion;

	@Column(name = "tiempo_sin_inactividad")
	private Integer tiempoSinInactividad;

	@Column(name = "validacion_biometrica", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean validacionBiometrica;

	@Column(name = "analisis_mirada", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean analisisMirada;

	@OneToOne
	@JoinColumn(name = "asignacion_id")
	private AsignacionExamen asignacion_id;

	@Column(name = "tiempo_duracion", columnDefinition = "INTEGER")
	private Integer tiempo_duracion;

	// --- Constructores ---

	public ConfiguracionExamen() {
	}

	public ConfiguracionExamen(Boolean camara, Boolean microfono, Integer maxCambioPestana, Integer toleranDesconexion,
			Integer tiempoSinInactividad, Boolean validacionBiometrica, Boolean analisisMirada) {
		this.camara = camara;
		this.microfono = microfono;
		this.maxCambioPestana = maxCambioPestana;
		this.toleranDesconexion = toleranDesconexion;
		this.tiempoSinInactividad = tiempoSinInactividad;
		this.validacionBiometrica = validacionBiometrica;
		this.analisisMirada = analisisMirada;
	}

	// --- Getters y Setters ---

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCamara() {
		return camara;
	}

	public void setCamara(Boolean camara) {
		this.camara = camara;
	}

	public Boolean getMicrofono() {
		return microfono;
	}

	public void setMicrofono(Boolean microfono) {
		this.microfono = microfono;
	}

	public Integer getMaxCambioPestana() {
		return maxCambioPestana;
	}

	public void setMaxCambioPestana(Integer maxCambioPestana) {
		this.maxCambioPestana = maxCambioPestana;
	}

	public Integer getToleranDesconexion() {
		return toleranDesconexion;
	}

	public void setToleranDesconexion(Integer toleranDesconexion) {
		this.toleranDesconexion = toleranDesconexion;
	}

	public Integer getTiempoSinInactividad() {
		return tiempoSinInactividad;
	}

	public void setTiempoSinInactividad(Integer tiempoSinInactividad) {
		this.tiempoSinInactividad = tiempoSinInactividad;
	}

	public Boolean getValidacionBiometrica() {
		return validacionBiometrica;
	}

	public void setValidacionBiometrica(Boolean validacionBiometrica) {
		this.validacionBiometrica = validacionBiometrica;
	}

	public Boolean getAnalisisMirada() {
		return analisisMirada;
	}

	public void setAnalisisMirada(Boolean analisisMirada) {
		this.analisisMirada = analisisMirada;
	}

	public Integer getTiempo_duracion() {
		return tiempo_duracion;
	}

	public void setTiempo_duracion(Integer tiempo_duracion) {
		this.tiempo_duracion = tiempo_duracion;
	}

	public AsignacionExamen getAsignacion_id() {
		return asignacion_id;
	}

	public void setAsignacion_id(AsignacionExamen asignacion_id) {
		this.asignacion_id = asignacion_id;
	}

}