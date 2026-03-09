package com.chaindrenciales.dashboardrh.dto;

import java.time.LocalDateTime;

import com.chaindrenciales.dashboardrh.enums.AccionBitacoraEnum;

public class BitacoraDetalleDTO {
/*
    private String accion;
    private String descripcion;
    private LocalDateTime fechaAccion;

    public BitacoraDetalleDTO(String accion, String descripcion, LocalDateTime fechaAccion) {
        this.accion = accion;
        this.descripcion = descripcion;
        this.fechaAccion = fechaAccion;
    }*/

	   private String nombreCompleto;
	    private Enum accion;
	    private String descripcion;
	    private LocalDateTime fechaAccion;

	    public BitacoraDetalleDTO(String nombreCompleto,
			                AccionBitacoraEnum accion,
			                LocalDateTime fechaAccion,
			                String descripcion) {
		this.nombreCompleto = nombreCompleto;
		this.accion = accion;
		this.fechaAccion = fechaAccion;
		this.descripcion = descripcion;
		}

		public String getNombreCompleto() {
			return nombreCompleto;
		}

		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}

		public Enum getAccion() {
			return accion;
		}

		public void setAccion(Enum accion) {
			this.accion = accion;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public LocalDateTime getFechaAccion() {
			return fechaAccion;
		}

		public void setFechaAccion(LocalDateTime fechaAccion) {
			this.fechaAccion = fechaAccion;
		}
	    
	    
	    
	    
}
