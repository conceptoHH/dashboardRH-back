package com.chaindrenciales.dashboardrh.dto;

public class InvitacionEmpresaResponseDTO {

    private Long id;
    private String nombre;
    private String email;
    private Long empresaId;
    private String rol;
    private String estado;

	public InvitacionEmpresaResponseDTO(Long id, String nombre, String email, Long empresaId, String rol, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.empresaId = empresaId;
		this.rol = rol;
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

    // constructor
}