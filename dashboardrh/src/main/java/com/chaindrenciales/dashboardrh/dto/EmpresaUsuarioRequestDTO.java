package com.chaindrenciales.dashboardrh.dto;

import com.chaindrenciales.dashboardrh.models.RolCorporativo;

public class EmpresaUsuarioRequestDTO {
	  private Long usuarioId;
	    private Long empresaId;
	    private RolCorporativo rol;

	    public Long getUsuarioId() { return usuarioId; }
	    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

	    public Long getEmpresaId() { return empresaId; }
	    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }

	    public RolCorporativo getRol() { return rol; }
	    public void setRol(RolCorporativo rol) { this.rol = rol; }
	}