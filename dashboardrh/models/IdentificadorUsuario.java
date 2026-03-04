package com.chaindrenciales.dashboardrh.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "identificadores")
public class IdentificadorUsuario {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chaindrencial_id", referencedColumnName = "id")
    private Chaindrencial chaindrencial;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    @JsonIgnoreProperties({ "telefono", "password", "hashBlockchain", "username", "accountNonExpired",
            "accountNonLocked", "credentialsNonExpired" })
    private Usuario usuario;

    @Column(nullable = false, unique = true, updatable = false)
    private String uuid;

    private String ambitoLaboral;
    private String dominioEspecializacion;
    private int experienciaLaboral;
    private String especializaciones;
    private int estadoActivo; // 0: Cerrado, 1: Activo, 2: Desactivado pero escuchando
    private boolean verificado;
    private int disponibilidad; // 1: Inmediata, 0: No disponible
    private String idiomas;
    private String nivelHabilidad;
    private String tecnologiaPrincipal;

    @Column(length = 1000)
    private String autoevaluacion;

    @Column(length = 1000)
    private String metasProfesionales;

    @Column(length = 1000)
    private String proyectosPersonales;

    @Column(length = 500)
    private String github;

    @Column(length = 500)
    private String linkedin;


    public String getAutoevaluacion() {
        return autoevaluacion;
    }

    public void setAutoevaluacion(String autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }

    public String getMetasProfesionales() {
        return metasProfesionales;
    }

    public void setMetasProfesionales(String metasProfesionales) {
        this.metasProfesionales = metasProfesionales;
    }

    public String getProyectosPersonales() {
        return proyectosPersonales;
    }

    public void setProyectosPersonales(String proyectosPersonales) {
        this.proyectosPersonales = proyectosPersonales;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAmbitoLaboral() {
        return ambitoLaboral;
    }

    public void setAmbitoLaboral(String ambitoLaboral) {
        this.ambitoLaboral = ambitoLaboral;
    }

    public String getDominioEspecializacion() {
        return dominioEspecializacion;
    }

    public void setDominioEspecializacion(String dominioEspecializacion) {
        this.dominioEspecializacion = dominioEspecializacion;
    }

    public int getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(int experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getEspecializaciones() {
        return especializaciones;
    }

    public void setEspecializaciones(String especializaciones) {
        this.especializaciones = especializaciones;
    }

    public int getEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(int estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getNivelHabilidad() {
        return nivelHabilidad;
    }

    public void setNivelHabilidad(String nivelHabilidad) {
        this.nivelHabilidad = nivelHabilidad;
    }

    public String getTecnologiaPrincipal() {
        return tecnologiaPrincipal;
    }

    public void setTecnologiaPrincipal(String tecnologiaPrincipal) {
        this.tecnologiaPrincipal = tecnologiaPrincipal;
    }

    public Chaindrencial getChaindrencial() {
        return chaindrencial;
    }

    public void setChaindrencial(Chaindrencial chaindrencial) {
        this.chaindrencial = chaindrencial;
    }
}