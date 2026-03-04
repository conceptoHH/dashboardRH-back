package com.chaindrenciales.dashboardrh.dto;

public class EmpresaResponseDTO {

    private Long id;
    private String nombre;
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String direccion;
    private boolean planActivo;

    public EmpresaResponseDTO() {}

    public EmpresaResponseDTO(Long id, String nombre, String razonSocial, String rfc,
                               String telefono, String direccion, boolean planActivo) {
        this.id = id;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.telefono = telefono;
        this.direccion = direccion;
        this.planActivo = planActivo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public boolean isPlanActivo() { return planActivo; }
    public void setPlanActivo(boolean planActivo) { this.planActivo = planActivo; }
}
