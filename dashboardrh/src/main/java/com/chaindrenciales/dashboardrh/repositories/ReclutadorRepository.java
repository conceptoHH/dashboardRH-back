package com.chaindrenciales.dashboardrh.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chaindrenciales.dashboardrh.dto.ReclutadorDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;
import com.chaindrenciales.dashboardrh.models.Usuario;

@Repository
public interface ReclutadorRepository extends JpaRepository<Usuario, Long>  {

	@Query("SELECT new com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO(" +
	           "u.id, u.nombre, u.apellidos, u.puesto, " +
	           "(SELECT COUNT(re) FROM ReclutadorEvaluador re WHERE re.reclutador.id = u.id AND re.empresa.id = :empresaId), " +
	           "0, " + // 0 como Carga de Trabajo (Pendiente de implementar)
	           "eu.activo, " +
	           "'Sin actividad reciente') " + // Placeholder para Actividad Reciente
	           "FROM EmpresaUsuario eu " +
	           "JOIN eu.usuario u " +
	           "WHERE eu.empresa.id = :empresaId " +
	           "AND eu.rolCorporativo = 'RECLUTADOR'")
	    List<ReclutadorResponseDTO> findDashboardReclutadoresByEmpresa(@Param("empresaId") Long empresaId);
	
	@Query("SELECT new com.chaindrenciales.dashboardrh.dto.ReclutadorDetalleDTO(" +
		       "u.id, u.nombre, u.apellidos, u.puesto, eu.activo, u.email, 0) " + // 0 es placeholder de candidatos
		       "FROM EmpresaUsuario eu " +
		       "JOIN eu.usuario u " +
		       "WHERE eu.empresa.id = :empresaId " +
		       "AND u.id = :reclutadorId " +
		       "AND eu.rolCorporativo = 'RECLUTADOR'")
		Optional<ReclutadorDetalleDTO> findDetalleReclutadorHeader(
		        @Param("reclutadorId") Long reclutadorId, 
		        @Param("empresaId") Long empresaId);

}