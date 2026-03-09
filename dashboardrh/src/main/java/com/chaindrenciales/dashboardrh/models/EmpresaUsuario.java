package com.chaindrenciales.dashboardrh.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa la relación activa entre un Usuario y una Empresa.
 * Aquí se define si es HR_ADMIN, RECLUTADOR o EVALUADOR.
 */
@Entity
@Table(
    name = "empresa_usuarios",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "empresa_id"})
    }
)
public class EmpresaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuario vinculado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Empresa asociada
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    // Rol dentro de la empresa
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_corporativo", nullable = false)
    private RolCorporativo rolCorporativo;

    // Indica si sigue activo dentro de la empresa
    @Column(nullable = false)
    private Boolean activo = true;

    // Usuario que realizó la asignación
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignado_por", nullable = false)
    private Usuario asignadoPor;

    // Fecha de asignación
    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion = LocalDateTime.now();

    // Fecha de desactivación si aplica
    @Column(name = "fecha_desactivacion")
    private LocalDateTime fechaDesactivacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public RolCorporativo getRolCorporativo() {
		return rolCorporativo;
	}

	public void setRolCorporativo(RolCorporativo rolCorporativo) {
		this.rolCorporativo = rolCorporativo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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

	public LocalDateTime getFechaDesactivacion() {
		return fechaDesactivacion;
	}

	public void setFechaDesactivacion(LocalDateTime fechaDesactivacion) {
		this.fechaDesactivacion = fechaDesactivacion;
	}


}