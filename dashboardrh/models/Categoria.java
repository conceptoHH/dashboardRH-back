package com.chaindrenciales.dashboardrh.models;


import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categorias")
public class Categoria {
	//private final UsuarioRepository usuarioRepository; // <----------- LO AGREGUE PARA QUE ME DEJARA HACER LA INSERSION DE VACANTES (CATEGORIA)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Examen> examenes = new LinkedHashSet<>();

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "reclutador_id") <------ LO QUITE PORQUE HACE SELECT AL MOMENTO DE INGRESAR 
  //  @JsonIgnoreProperties({ "password", "username", "accountNonExpired", "accountNonLocked",
     //       "credentialsNonExpired", "enabled", "authorities", "fecha_nacimiento", "lugar_nacimiento" })
    //private Usuario reclutador;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reclutador_id")
    @JsonIgnore  
    private Usuario reclutador;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "tipo_lugar_trabajo")
    private String tipoLugarTrabajo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "tipo_empleo")
    private String tipoEmpleo;

    @Column(name = "descripcion_puesto", columnDefinition = "TEXT")
    private String descripcionPuesto;

    @Column(name = "requisitos", columnDefinition = "TEXT")
    private String requisitos;

    @Column(name = "sueldo_minimo")
    private Double sueldoMinimo;

    @Column(name = "sueldo_maximo")
    private Double sueldoMaximo;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "frecuencia_pago")
    private String frecuenciaPago;

    @Column(name = "beneficios", columnDefinition = "TEXT")
    private String beneficios;

    @Column(name = "nivel_experiencia")
    private String nivelExperiencia;

    @Column(name = "estado")
    private String estado; // "borrador" | "publicada" | "pausada"

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @Column(name = "idiomas", columnDefinition = "TEXT")
    private String idiomas; // se guarda como "es,en,fr"

    @Column(name = "tecnologia_principal")
    private String tecnologiaPrincipal;

    @Column(name = "tecnologias_secundarias", columnDefinition = "TEXT")
    private String tecnologiasSecundarias; // se guarda como "Angular,Spring,PostgreSQL"

    @Column(name = "ambito_laboral")
    private String ambitoLaboral;

    @Column(name = "dispuesto_reubicacion")
    private Boolean dispuestoReubicacion;


    // --- Constructores, getters y setters ---

    public Categoria() {
    }

    // Constructor simplificado para cuando guardas desde el front
    public Categoria(String cargo, String tipoLugarTrabajo, String ubicacion, String tipoEmpleo,
            String descripcionPuesto, String requisitos, Double sueldoMinimo,
            Double sueldoMaximo, String moneda, String frecuenciaPago, String beneficios,
            String nivelExperiencia, String estado,
            Date fechaPublicacion, Usuario reclutador, String idiomas, String tecnologiaPrincipal,
            String tecnologiasSecundarias, String ambitoLaboral, Boolean dispuestoReubicacion) {
        this.cargo = cargo;
        this.tipoLugarTrabajo = tipoLugarTrabajo;
        this.ubicacion = ubicacion;
        this.tipoEmpleo = tipoEmpleo;
        this.descripcionPuesto = descripcionPuesto;
        this.requisitos = requisitos;
        this.sueldoMinimo = sueldoMinimo;
        this.sueldoMaximo = sueldoMaximo;
        this.moneda = moneda;
        this.frecuenciaPago = frecuenciaPago;
        this.beneficios = beneficios;
        this.nivelExperiencia = nivelExperiencia;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
        this.reclutador = reclutador;
        this.idiomas = idiomas;
        this.tecnologiaPrincipal = tecnologiaPrincipal;
        this.tecnologiasSecundarias = tecnologiasSecundarias;
        this.ambitoLaboral = ambitoLaboral;
        this.dispuestoReubicacion = dispuestoReubicacion;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Set<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(Set<Examen> examenes) {
        this.examenes = examenes;
    }

    public Usuario getReclutador() {
        return reclutador;
    }

    public void setReclutador(Usuario reclutador) {
        this.reclutador = reclutador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipoLugarTrabajo() {
        return tipoLugarTrabajo;
    }

    public void setTipoLugarTrabajo(String tipoLugarTrabajo) {
        this.tipoLugarTrabajo = tipoLugarTrabajo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoEmpleo() {
        return tipoEmpleo;
    }

    public void setTipoEmpleo(String tipoEmpleo) {
        this.tipoEmpleo = tipoEmpleo;
    }

    public String getDescripcionPuesto() {
        return descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Double getSueldoMinimo() {
        return sueldoMinimo;
    }

    public void setSueldoMinimo(Double sueldoMinimo) {
        this.sueldoMinimo = sueldoMinimo;
    }

    public Double getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(Double sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getTecnologiaPrincipal() {
        return tecnologiaPrincipal;
    }

    public void setTecnologiaPrincipal(String tecnologiaPrincipal) {
        this.tecnologiaPrincipal = tecnologiaPrincipal;
    }

    public String getTecnologiasSecundarias() {
        return tecnologiasSecundarias;
    }

    public void setTecnologiasSecundarias(String tecnologiasSecundarias) {
        this.tecnologiasSecundarias = tecnologiasSecundarias;
    }

    public String getAmbitoLaboral() {
        return ambitoLaboral;
    }

    public void setAmbitoLaboral(String ambitoLaboral) {
        this.ambitoLaboral = ambitoLaboral;
    }

    public Boolean getDispuestoReubicacion() {
        return dispuestoReubicacion;
    }

    public void setDispuestoReubicacion(Boolean dispuestoReubicacion) {
        this.dispuestoReubicacion = dispuestoReubicacion;
    }
}
