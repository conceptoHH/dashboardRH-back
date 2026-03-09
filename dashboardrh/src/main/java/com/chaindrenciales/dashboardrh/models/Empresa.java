package com.chaindrenciales.dashboardrh.models;


import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String direccion;

    // 📌 Nueva propiedad
    private boolean planActivo = true; // activo por defecto

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    /**
     * @OneToMany(mappedBy = "empresa")
    private List<Usuario> empleados;
     */

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

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isPlanActivo() {
		return planActivo;
	}

	public void setPlanActivo(boolean planActivo) {
		this.planActivo = planActivo;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	/*
	 * public List<Usuario> getEmpleados() { return empleados; }
	 * 
	 * public void setEmpleados(List<Usuario> empleados) { this.empleados =
	 * empleados; }
	 */

}
