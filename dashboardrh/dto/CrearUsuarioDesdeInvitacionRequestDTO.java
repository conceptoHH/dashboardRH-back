package com.chaindrenciales.dashboardrh.dto;

public class CrearUsuarioDesdeInvitacionRequestDTO {

    private Long invitacionId;
    private String nombre;
    private String apellidos;
    private String username;
    private String password;
    private String telefono;
    private String puesto;

	public String getPuesto() {	return puesto;	}
	public void setPuesto(String puesto) { this.puesto = puesto; }
	
	public Long getInvitacionId() { return invitacionId; }
    public void setInvitacionId(Long invitacionId) { this.invitacionId = invitacionId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
