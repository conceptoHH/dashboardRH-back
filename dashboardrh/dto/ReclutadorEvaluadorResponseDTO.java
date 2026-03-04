package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;

public class ReclutadorEvaluadorResponseDTO {

    private Long id;
    private Long reclutadorId;
    private Long evaluadorId;
    private Long empresaId;
    private Boolean activo;
    private LocalDateTime fechaAsignacion;

    public ReclutadorEvaluadorResponseDTO() {}

    public ReclutadorEvaluadorResponseDTO(Long id, Long reclutadorId, Long evaluadorId,
                                           Long empresaId, Boolean activo,
                                           LocalDateTime fechaAsignacion) {
        this.id = id;
        this.reclutadorId = reclutadorId;
        this.evaluadorId = evaluadorId;
        this.empresaId = empresaId;
        this.activo = activo;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getReclutadorId() { return reclutadorId; }
    public void setReclutadorId(Long reclutadorId) { this.reclutadorId = reclutadorId; }

    public Long getEvaluadorId() { return evaluadorId; }
    public void setEvaluadorId(Long evaluadorId) { this.evaluadorId = evaluadorId; }

    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalDateTime getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
}
