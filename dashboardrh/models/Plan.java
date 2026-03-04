package com.chaindrenciales.dashboardrh.models;


import java.util.List;



import jakarta.persistence.*;


@Entity
@Table(name = "planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;              // Ej: "Plan Básico", "Plan PRO", etc.
    private Integer maxReclutadores;    // Límite de reclutadores permitidos
    private Integer maxEvaluadores;     // Límite de evaluadores permitidos
    private boolean accesoMetricas;     // Si puede ver métricas avanzadas
    private boolean accesoFormularios;  // Si puede usar formularios personalizados
    private boolean accesoReportes;     // Si puede exportar reportes
    private boolean activo;             // El plan está disponible públicamente

    @OneToMany(mappedBy = "plan")
    private List<Empresa> empresas;

    // Getters y Setters
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

    public Integer getMaxReclutadores() {
        return maxReclutadores;
    }

    public void setMaxReclutadores(Integer maxReclutadores) {
        this.maxReclutadores = maxReclutadores;
    }

    public Integer getMaxEvaluadores() {
        return maxEvaluadores;
    }

    public void setMaxEvaluadores(Integer maxEvaluadores) {
        this.maxEvaluadores = maxEvaluadores;
    }

    public boolean isAccesoMetricas() {
        return accesoMetricas;
    }

    public void setAccesoMetricas(boolean accesoMetricas) {
        this.accesoMetricas = accesoMetricas;
    }

    public boolean isAccesoFormularios() {
        return accesoFormularios;
    }

    public void setAccesoFormularios(boolean accesoFormularios) {
        this.accesoFormularios = accesoFormularios;
    }

    public boolean isAccesoReportes() {
        return accesoReportes;
    }

    public void setAccesoReportes(boolean accesoReportes) {
        this.accesoReportes = accesoReportes;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
