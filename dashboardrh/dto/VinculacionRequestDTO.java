package com.chaindrenciales.dashboardrh.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class VinculacionRequestDTO {

    @NotNull(message = "El ID del reclutador es obligatorio")
    private Long reclutadorId;

    @NotEmpty(message = "Debe proporcionar al menos un ID de evaluador para vincular")
    private List<Long> evaluadoresId;

    public VinculacionRequestDTO() {}

	// Getters
	public Long getReclutadorId() {
		return reclutadorId;
	}

	public List<Long> getEvaluadoresId() {
		return evaluadoresId;
	}

	// Setters
	public void setReclutadorId(Long reclutadorId) {
		this.reclutadorId = reclutadorId;
	}

	public void setEvaluadoresId(List<Long> evaluadoresId) {
		this.evaluadoresId = evaluadoresId;
	}
}