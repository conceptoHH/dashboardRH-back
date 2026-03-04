package com.chaindrenciales.dashboardrh.models;

import jakarta.persistence.*;

import com.chaindrenciales.dashboardrh.enums.AccionBitacoraEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Entity
@Table(name = "bitacora_rh")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BitacoraRH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bitacora_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name="accion",nullable = false)
    private AccionBitacoraEnum accion;


    @Column(name = "fecha_accion", nullable = false, updatable = false)
    private LocalDateTime fechaAccion;


    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @PrePersist
    protected void onCreate() {
        this.fechaAccion = LocalDateTime.now();
    }

    // --- Constructores ---

    public BitacoraRH() {
    }

    public BitacoraRH(Empresa empresa, Usuario usuario, AccionBitacoraEnum accion, String descripcion) {
        this.empresa = empresa;
        this.usuario = usuario;
        this.accion = accion;
        this.descripcion = descripcion;
    }

    // --- Getters y Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AccionBitacoraEnum getAccion() {
        return accion;
    }

    public void setAccion(AccionBitacoraEnum accion) {
        this.accion = accion;
    }

    public LocalDateTime getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(LocalDateTime fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
