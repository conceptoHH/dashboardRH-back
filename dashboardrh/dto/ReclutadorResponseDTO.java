package com.chaindrenciales.dashboardrh.dto;

public class ReclutadorResponseDTO {
	
	private Long reclutadorId;
    private String nombreReclutador;
    private String apellidos;
    private String puesto;
    private Long totalEvaluadoresAsociados;
    private Integer cargaDeTrabajo;
    private Boolean estado;
    private String actividadReciente;
    private String telefono;
    private String correo;
    
    public ReclutadorResponseDTO() {}

	public ReclutadorResponseDTO(Long reclutadorId, String nombreReclutador, String apellidos, String puesto,
			Long totalEvaluadoresAsociados, Integer cargaDeTrabajo, Boolean estado, String actividadReciente) {
		super();
		this.reclutadorId = reclutadorId;
		this.nombreReclutador = nombreReclutador;
		this.apellidos = apellidos;
		this.puesto = puesto;
		this.totalEvaluadoresAsociados = totalEvaluadoresAsociados;
		this.cargaDeTrabajo = cargaDeTrabajo;
		this.estado = estado;
		this.actividadReciente = actividadReciente;
	}
    
    public Long getReclutadorId() {
		return reclutadorId;
	}

	public void setReclutadorId(Long reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

	public String getNombreReclutador() {
		return nombreReclutador;
	}

	public void setNombreReclutador(String nombreReclutador) {
		this.nombreReclutador = nombreReclutador;
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
	
	public Long getTotalEvaluadoresAsociados() {
		return totalEvaluadoresAsociados;
	}

	public void setTotalEvaluadoresAsociados(Long totalEvaluadoresAsociados) {
		this.totalEvaluadoresAsociados = totalEvaluadoresAsociados;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


}
