package com.chaindrenciales.dashboardrh.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "roles")
public class Rol {
	
	
	@Id
	private Long rolId; 
	private String nombre_rol; 
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "rol")
	private Set<UsuarioRol> usuarioRoles = new HashSet<>();


	public Long getRolId() {
		return rolId;
	}


	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}


	public String getNombre_rol() {
		return nombre_rol;
	}


	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}


	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}


	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}


}	
