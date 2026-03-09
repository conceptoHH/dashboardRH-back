package com.chaindrenciales.dashboardrh.models;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluador_categoria")
public class EvaluadorCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evaluador_id")
    private Usuario evaluador;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    @ManyToOne
    private Usuario reclutadorCreador;

    
    
    public EvaluadorCategoria() {
        // Constructor vacío necesario para Spring/Hibernate
    }

	public EvaluadorCategoria(Long id, Usuario evaluador, Categoria categoria, Usuario reclutadorCreador) {
		super();
		this.id = id;
		this.evaluador = evaluador;
		this.categoria = categoria;
		this.reclutadorCreador = reclutadorCreador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(Usuario evaluador) {
		this.evaluador = evaluador;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getReclutadorCreador() {
		return reclutadorCreador;
	}

	public void setReclutadorCreador(Usuario reclutadorCreador) {
		this.reclutadorCreador = reclutadorCreador;
	}


	

}
