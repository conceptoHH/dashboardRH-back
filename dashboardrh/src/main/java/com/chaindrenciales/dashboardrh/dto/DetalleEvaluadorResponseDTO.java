			package com.chaindrenciales.dashboardrh.dto;
			
			import java.util.List;
			import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;
			
			public class DetalleEvaluadorResponseDTO {
				private Long evaluadorId;
				private String nombreCompleto;
				private String apellidos;
				private String puesto;
				private Boolean estado;
				private String correoElectronico;
				private Integer evaluacionesPendientes;
			
			// 	private List<EvaluadorResumenDTO> evaluadoresAsignados;
		//	    private Integer candidatosPendientes; // <--- necesario
			    private List<EmpleadoResumenDTO> reclutadores; // <--- necesario
				public DetalleEvaluadorResponseDTO() {
				}
			
				public DetalleEvaluadorResponseDTO(Long evaluadorId, String nombreCompleto, String apellidos, String puesto,
						Boolean estado, String correoElectronico, Integer evaluacionesPendientes) {
					this.evaluadorId = evaluadorId;
					this.nombreCompleto = nombreCompleto;
					this.apellidos = apellidos;
					this.puesto = puesto;
					this.estado = estado;
					this.correoElectronico = correoElectronico;
					this.evaluacionesPendientes = evaluacionesPendientes;
				}
			
			// --- Getters y Setters ---
				
				
				
				public Long getEvaluadorId() {
					return evaluadorId;
				}
			
	/*		public Integer getCandidatosPendientes() {
					return candidatosPendientes;
				}
			
				public void setCandidatosPendientes(Integer candidatosPendientes) {
					this.candidatosPendientes = candidatosPendientes;
				}*/
			

			
				public void setEvaluadorId(Long evaluadorId) {
					this.evaluadorId = evaluadorId;
				}
			
				public List<EmpleadoResumenDTO> getReclutadores() {
					return reclutadores;
				}

				public void setReclutadores(List<EmpleadoResumenDTO> reclutadores) {
					this.reclutadores = reclutadores;
				}

				public String getNombreCompleto() {
					return nombreCompleto;
				}
			
				public void setNombreCompleto(String nombreCompleto) {
					this.nombreCompleto = nombreCompleto;
				}
			
				public String getApellidos() {
					return apellidos;
				}
			
				public void setApellidos(String apellidos) {
					this.apellidos = apellidos;
				}
			
				public String getPuesto() {
					return puesto;
				}
			
				public void setPuesto(String puesto) {
					this.puesto = puesto;
				}
			
				public Boolean getEstado() {
					return estado;
				}
			
				public void setEstado(Boolean estado) {
					this.estado = estado;
				}
			
				public String getCorreoElectronico() {
					return correoElectronico;
				}
			
				public void setCorreoElectronico(String correoElectronico) {
					this.correoElectronico = correoElectronico;
				}
			
				public Integer getEvaluacionesPendientes() {
					return evaluacionesPendientes;
				}
			
				public void setEvaluacionesPendientes(Integer evaluacionesPendientes) {
					this.evaluacionesPendientes = evaluacionesPendientes;
				}
			/*
				public List<EvaluadorResumenDTO> getEvaluadoresAsignados() {
					return evaluadoresAsignados;
				}
			
				public void setEvaluadoresAsignados(List<EvaluadorResumenDTO> evaluadoresAsignados) {
					this.evaluadoresAsignados = evaluadoresAsignados;
				}
			*/
			}