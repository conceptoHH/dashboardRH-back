package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;

public class EmpresaUsuarioResponseDTO {

    private Long id;
    private Long usuarioId;
    private Long empresaId;
    private String rolCorporativo;
    private Boolean activo;
    private LocalDateTime fechaAsignacion;

    public EmpresaUsuarioResponseDTO() {}

    public EmpresaUsuarioResponseDTO(Long id, Long usuarioId, Long empresaId,
                                      String rolCorporativo, Boolean activo,
                                      LocalDateTime fechaAsignacion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.empresaId = empresaId;
        this.rolCorporativo = rolCorporativo;
        this.activo = activo;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }

    public String getRolCorporativo() { return rolCorporativo; }
    public void setRolCorporativo(String rolCorporativo) { this.rolCorporativo = rolCorporativo; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalDateTime getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
}
