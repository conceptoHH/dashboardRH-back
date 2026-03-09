package com.chaindrenciales.dashboardrh.dto;

public class ExamenRequestDTO {
	 private Boolean activo;
	    private String descripcion;
	    private String numeroDePreguntas;
	    private String puntosMaximos;
	    private String tipoExamen;
	    private String titulo;
	    private Long categoriaId;
	    private Long evaluadorId;
	    private Long reclutadorId;
		public Boolean getActivo() {
			return activo;
		}
		public void setActivo(Boolean activo) {
			this.activo = activo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getNumeroDePreguntas() {
			return numeroDePreguntas;
		}
		public void setNumeroDePreguntas(String numeroDePreguntas) {
			this.numeroDePreguntas = numeroDePreguntas;
		}
		public String getPuntosMaximos() {
			return puntosMaximos;
		}
		public void setPuntosMaximos(String puntosMaximos) {
			this.puntosMaximos = puntosMaximos;
		}
		public String getTipoExamen() {
			return tipoExamen;
		}
		public void setTipoExamen(String tipoExamen) {
			this.tipoExamen = tipoExamen;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public Long getCategoriaId() {
			return categoriaId;
		}
		public void setCategoriaId(Long categoriaId) {
			this.categoriaId = categoriaId;
		}
		public Long getEvaluadorId() {
			return evaluadorId;
		}
		public void setEvaluadorId(Long evaluadorId) {
			this.evaluadorId = evaluadorId;
		}
		public Long getReclutadorId() {
			return reclutadorId;
		}
		public void setReclutadorId(Long reclutadorId) {
			this.reclutadorId = reclutadorId;
		}
	    
	    
	    
	    
}
