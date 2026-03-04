package com.chaindrenciales.dashboardrh.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class UsuarioEmpleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@OneToOne
	private Usuario empleado;
	
	@ManyToOne
	private Empresa empresa;
	
	private String nombre_empresa;
	private String cargo;
	private Boolean isEmpleado;
	private Boolean flag_compartir_empresa;
	private String rfc;
	private String correo;
	
	public UsuarioEmpleado( ) {
		
	}
	
	public UsuarioEmpleado(Long id, Usuario empleado, Empresa empresa, String nombre_empresa, String cargo,
			Boolean isEmpleado, Boolean flag_compartir_empresa, String rfc, String correo) {
		super();
		Id = id;
		this.empleado = empleado;
		this.empresa = empresa;
		this.nombre_empresa = nombre_empresa;
		this.cargo = cargo;
		this.isEmpleado = isEmpleado;
		this.flag_compartir_empresa = flag_compartir_empresa;
		this.rfc = rfc;
		this.correo = correo;
	}
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Usuario getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Usuario empleado) {
		this.empleado = empleado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Boolean getIsEmpleado() {
		return isEmpleado;
	}

	public void setIsEmpleado(Boolean isEmpleado) {
		this.isEmpleado = isEmpleado;
	}

	public Boolean getFlag_compartir_empresa() {
		return flag_compartir_empresa;
	}

	public void setFlag_compartir_empresa(Boolean flag_compartir_empresa) {
		this.flag_compartir_empresa = flag_compartir_empresa;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
