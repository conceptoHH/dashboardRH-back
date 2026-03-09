package com.chaindrenciales.dashboardrh.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chaindrenciales.dashboardrh.models.Usuario;

@Repository
public interface DashboardRHRepository extends JpaRepository<Usuario, Long> {
/*
    // Contar todos los usuarios con rol 'RECLUTADOR'
    @Query("SELECT COUNT(u) " +
           "FROM Usuario u " +
           "JOIN u.usuarioRoles ur " +
           "JOIN ur.rol r " +
           "WHERE r.nombreRol = 'RECLUTADOR'")
    Long contarReclutadores();

    // Contar todos los usuarios con rol 'EVALUADOR'
    @Query("SELECT COUNT(u) " +
           "FROM Usuario u " +
           "JOIN u.usuarioRoles ur " +
           "JOIN ur.rol r " +
           "WHERE r.nombreRol = 'EVALUADOR'")
    Long contarEvaluadores();
    
    // Total carga de trabajo por empresa
    @Query("SELECT (COUNT(DISTINCT re.evaluador.id) + " +
           "COUNT(CASE WHEN eu.calificado = false THEN 1 END)) " +
           "FROM ReclutadorEvaluador re " +
           "JOIN re.examenUsuarios eu " +
           "JOIN re.reclutador r " +
           "WHERE r.empresa.id = :empresaId")
    Long totalCargaTrabajoPorEmpresa(@Param("empresaId") Long empresaId);

    // Últimas 10 acciones de la empresa
    @Query("SELECT u " +
           "FROM Bitacora b " +
           "JOIN b.usuario u " +
           "WHERE b.empresa.id = :empresaId " +
           "ORDER BY b.fechaAccion DESC")
    List<Usuario> ultimasAccionesPorEmpresa(@Param("empresaId") Long empresaId);*/
}