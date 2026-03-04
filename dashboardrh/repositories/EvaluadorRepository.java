package com.chaindrenciales.dashboardrh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chaindrenciales.dashboardrh.dto.DetalleEvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.models.Usuario;

@Repository
public interface EvaluadorRepository extends JpaRepository<Usuario, Long> {
/*
	//seleccionamos 
    @Query("SELECT new com.chaindrenciales.dashboardrh.dto.DetalleEvaluadorResponseDTO(" +
           "u.id, u.nombre, u.apellidos, u.email, u.telefono, u.puesto, u.empresa.id, " +
           "COUNT(DISTINCT eu.examen.id), " +
           "COUNT(CASE WHEN eu.calificado = true THEN 1 END), " +
           "COUNT(CASE WHEN eu.calificado = false THEN 1 END)) " +
           "FROM Usuario u " +
           "JOIN u.usuarioRoles ur " +
           "JOIN ur.rol r " +
           "LEFT JOIN u.examenesUsuario eu " +
           "WHERE r.nombreRol = 'EVALUADOR' " +
           "AND u.id = :evaluadorId " +
           "AND u.empresa.id = :empresaId " +
           "GROUP BY u.id, u.nombre, u.apellidos, u.email, u.telefono, u.puesto, u.empresa.id")
    Optional<DetalleEvaluadorResponseDTO> obtenerDetalleEvaluador(
            @Param("evaluadorId") Long evaluadorId,
            @Param("empresaId") Long empresaId);
*/
}