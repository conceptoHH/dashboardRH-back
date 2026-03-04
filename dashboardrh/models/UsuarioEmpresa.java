package com.chaindrenciales.dashboardrh.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class UsuarioEmpresa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne
	private Usuario liderRH;
	
	@ManyToOne
	private Empresa empresa;
	
	public UsuarioEmpresa() {
		
	}

	public UsuarioEmpresa(Long id, Usuario liderRH, Empresa empresa) {
		this.id = id;
		this.liderRH = liderRH;
		this.empresa = empresa;
	}

	// --- GETTERS Y SETTERS ---
	public Usuario getLiderRH() {
		return liderRH;
	}

	public void setLiderRH(Usuario liderRH) {
		this.liderRH = liderRH;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
