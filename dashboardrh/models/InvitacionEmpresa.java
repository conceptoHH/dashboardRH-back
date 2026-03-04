package com.chaindrenciales.dashboardrh.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa una invitación para vincular un usuario a una empresa.
 * Puede ser:
 * - Onboarding del primer HR_ADMIN
 * - Invitación posterior de reclutadores o evaluadores
 */
@Entity
@Table(name = "invitaciones_empresa")
public class InvitacionEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del invitado (para personalizar el email)
    @Column(nullable = false)
    private String nombre;

    // Email al que se envía la invitación
    @Column(nullable = false)
    private String email;

    // Empresa asociada
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    // Rol que tendrá dentro de la empresa
    @Enumerated(EnumType.STRING)
    @Column(name = "rol_corporativo", nullable = false)
    private RolCorporativo rolCorporativo;

    // Usuario que creó la invitación (SuperAdmin o HR_ADMIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creado_por", nullable = false)
    private Usuario creadoPor;

    // Fecha de envío
    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio = LocalDateTime.now();


    // Estado actual
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoInvitacion estado = EstadoInvitacion.PENDIENTE;

    // Fecha en que fue aceptada
    @Column(name = "fecha_aceptacion")
    private LocalDateTime fechaAceptacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Usuario getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(Usuario creadoPor) {
		this.creadoPor = creadoPor;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}


	public EstadoInvitacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInvitacion estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaAceptacion() {
		return fechaAceptacion;
	}

	public void setFechaAceptacion(LocalDateTime fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
	}

    // Getters y Setters
}