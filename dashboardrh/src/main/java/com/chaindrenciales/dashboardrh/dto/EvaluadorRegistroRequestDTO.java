package com.chaindrenciales.dashboardrh.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class EvaluadorRegistroRequestDTO {

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId; // [cite: 1324]

    @NotEmpty(message = "Debe asignar al menos una categoría")
    private List<Long> categoriaIds; // [cite: 1325]

    @NotNull(message = "El puesto es obligatorio")
    private String puesto; // [cite: 1326]

    public EvaluadorRegistroRequestDTO() {}

    // Getters
	public Long getUsuarioId() {
		return usuarioId;
	}

	public List<Long> getCategoriaIds() {
		return categoriaIds;
	}

	public String getPuesto() {
		return puesto;
	}

	// Setters
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void setCategoriaIds(List<Long> categoriaIds) {
		this.categoriaIds = categoriaIds;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
}