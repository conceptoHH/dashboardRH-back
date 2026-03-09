package com.chaindrenciales.dashboardrh.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa la relación entre un Reclutador y un Evaluador
 * dentro de una misma empresa.
 */
@Entity
@Table(
    name = "reclutador_evaluador",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "reclutador_id",
            "evaluador_id",
            "empresa_id"
        })
    }
)
public class ReclutadorEvaluador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Usuario con rol RECLUTADOR
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reclutador_id", nullable = false)
    private Usuario reclutador;

    /**
     * Usuario con rol EVALUADOR
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluador_id", nullable = false)
    private Usuario evaluador;

    /**
     * Empresa donde aplica la relación
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    /**
     * Usuario que realizó la asignación (HR_ADMIN)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignado_por", nullable = false)
    private Usuario asignadoPor;

    /**
     * Fecha de asignación
     */
    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion = LocalDateTime.now();

    /**
     * Indica si la relación está activa
     */
    @Column(nullable = false)
    private Boolean activo = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getReclutador() {
		return reclutador;
	}

	public void setReclutador(Usuario reclutador) {
		this.reclutador = reclutador;
	}

	public Usuario getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(Usuario evaluador) {
		this.evaluador = evaluador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getAsignadoPor() {
		return asignadoPor;
	}

	public void setAsignadoPor(Usuario asignadoPor) {
		this.asignadoPor = asignadoPor;
	}

	public LocalDateTime getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

    // Getters y Setters


    // Getters y Setters
}

/*
import java.time.LocalDateTime;

import com.chaindrenciales.dashboardrh.enums.EstadoVinculoEvaluador;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reclutador_evaluador")
@Data
public class ReclutadorEvaluador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluador_id", referencedColumnName = "id", nullable = false)
    private Usuario evaluador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reclutador_id", referencedColumnName = "id", nullable = false)
    private Usuario reclutador;
    
    private LocalDateTime fecha_vinculacion;
    
	@Enumerated(EnumType.STRING)
	@Column(name = "estatus_vinculo")
    private EstadoVinculoEvaluador estatus;
    

    public ReclutadorEvaluador() {}

    public ReclutadorEvaluador(Usuario evaluador, Usuario reclutador) {
        this.evaluador = evaluador;
        this.reclutador = reclutador;
    }

	public LocalDateTime getFecha_vinculacion() {
		return fecha_vinculacion;
	}

	public void setFecha_vinculacion(LocalDateTime fecha_vinculacion) {
		this.fecha_vinculacion = fecha_vinculacion;
	}

	public EstadoVinculoEvaluador getEstatus() {
		return estatus;
	}

	public void setEstatus(EstadoVinculoEvaluador estatus) {
		this.estatus = estatus;
	}
}*/