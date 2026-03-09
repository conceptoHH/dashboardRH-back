package com.chaindrenciales.dashboardrh.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReclutadorRequestDTO {

    private String nombreReclutador;

    private String apellidos;

    @Email(message = "Debe ser un correo válido")
    private String correoElectronico;

    private String puesto;

    private String telefono;

    @NotNull(message = "El ID de la empresa es obligatorio")
    private Long empresaid;

    public ReclutadorRequestDTO() {}

    // Getters
	public String getNombreReclutador() {
		return nombreReclutador;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getPuesto() {
		return puesto;
	}

	public String getTelefono() {
		return telefono;
	}

	public Long getEmpresaid() {
		return empresaid;
	}

    // Setters
	public void setNombreReclutador(String nombreReclutador) {
		this.nombreReclutador = nombreReclutador;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmpresaid(Long empresaid) {
		this.empresaid = empresaid;
	}
}