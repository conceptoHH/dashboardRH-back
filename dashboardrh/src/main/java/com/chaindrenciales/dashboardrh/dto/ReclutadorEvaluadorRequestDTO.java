package com.chaindrenciales.dashboardrh.dto;

public class ReclutadorEvaluadorRequestDTO {

	  private Long reclutadorId;
	    private Long evaluadorId;
	    private Long empresaId;

	    public Long getReclutadorId() { return reclutadorId; }
	    public void setReclutadorId(Long reclutadorId) { this.reclutadorId = reclutadorId; }

	    public Long getEvaluadorId() { return evaluadorId; }
	    public void setEvaluadorId(Long evaluadorId) { this.evaluadorId = evaluadorId; }

	    public Long getEmpresaId() { return empresaId; }
	    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
	}