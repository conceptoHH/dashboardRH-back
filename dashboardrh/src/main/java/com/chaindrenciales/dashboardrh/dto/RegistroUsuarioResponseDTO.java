package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDate;

public class RegistroUsuarioResponseDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String username;
    private String telefono;
    private Long empresaId;
    private LocalDate fechaRegistro;
    private String rol;
    private String puesto;

    public RegistroUsuarioResponseDTO(Long id, String nombre, String apellidos, String email,
                                      String username, String telefono, Long empresaId,
                                      LocalDate fechaRegistro, String rol, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.username = username;
        this.telefono = telefono;
        this.empresaId = empresaId;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
        this.rol = puesto;
    }

    public String getPuesto() { return puesto;	}
	public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getTelefono() { return telefono; }
    public Long getEmpresaId() { return empresaId; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public String getRol() { return rol; }
}
