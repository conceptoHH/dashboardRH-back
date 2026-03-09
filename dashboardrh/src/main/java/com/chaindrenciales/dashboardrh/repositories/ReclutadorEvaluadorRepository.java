package com.chaindrenciales.dashboardrh.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chaindrenciales.dashboardrh.dto.EvaluadorAsignadoResponseDTO;
import com.chaindrenciales.dashboardrh.models.ReclutadorEvaluador;
import com.chaindrenciales.dashboardrh.models.Usuario;

@Repository
public interface ReclutadorEvaluadorRepository extends JpaRepository<ReclutadorEvaluador, Long> {
 
	/*
	//muestra todos los evaluadores que estan asociados con un reclutador en especifico  
    @Query("SELECT new com.chaindrenciales.dashboardrh.dto.EvaluadorAsignadoResponseDTO(" +
           "u.id, u.nombre, u.apellidos, u.email, u.telefono, u.puesto, " +
           "COUNT(DISTINCT eu.examenId), " +
           "SUM(CASE WHEN eu.calificado = true THEN 1 ELSE 0 END), " +
           "SUM(CASE WHEN eu.calificado = false THEN 1 ELSE 0 END)) " +
           "FROM ReclutadorEvaluador re " +
           "JOIN re.evaluador u " +
           "LEFT JOIN u.examenes eu " +
           "WHERE re.reclutador.id = :reclutadorId " +
           "GROUP BY u.id, u.nombre, u.apellidos, u.email, u.telefono, u.puesto " +
           "ORDER BY u.nombre")
    List<EvaluadorAsignadoResponseDTO> obtenerEvaluadoresPorReclutador(@Param("reclutadorId") Long reclutadorId);
*/
	
    // Buscar todas las relaciones dentro de una empresa
    List<ReclutadorEvaluador> findByEmpresaId(Long empresaId);

    @EntityGraph(attributePaths = {"evaluador"})
    // Buscar todos los evaluadores asignados a un reclutador en una empresa
    List<ReclutadorEvaluador> findByReclutadorIdAndEmpresaId(
            Long reclutadorId,
            Long empresaId
    );

    // Buscar todos los reclutadores asociados a un evaluador en una empresa
    List<ReclutadorEvaluador> findByEvaluadorIdAndEmpresaId(
            Long evaluadorId,
            Long empresaId
    );

    // Validar si ya existe la relación reclutador-evaluador en esa empresa
    boolean existsByReclutadorIdAndEvaluadorIdAndEmpresaId(
            Long reclutadorId,
            Long evaluadorId,
            Long empresaId
    );

    // Obtener relación específica
    Optional<ReclutadorEvaluador> 
        findByReclutadorIdAndEvaluadorIdAndEmpresaId(
            Long reclutadorId,
            Long evaluadorId,
            Long empresaId
    );
}