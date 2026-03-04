package com.chaindrenciales.dashboardrh.repositories;

import com.chaindrenciales.dashboardrh.dto.BitacoraDetalleDTO;
import com.chaindrenciales.dashboardrh.models.BitacoraRH;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitacoraRepository extends JpaRepository<BitacoraRH, Long> {

    // Buscar por empresa
    List<BitacoraRH> findByEmpresaId(Long empresaId);

    // Buscar por usuario
    List<BitacoraRH> findByUsuarioId(Long usuarioId);

    // Buscar por empresa ordenado por fecha descendente
    List<BitacoraRH> findByEmpresaIdOrderByFechaAccionDesc(Long empresaId);

    // Obtener Top 10 registros para dashboard
    @Query("""
        SELECT new com.chaindrenciales.dashboardrh.dto.BitacoraDetalleDTO(
            b.usuario.nombre,
            b.accion,
            b.fechaAccion,
            b.descripcion
        )
        FROM BitacoraRH b
        ORDER BY b.fechaAccion DESC
        """)
    List<BitacoraDetalleDTO> obtenerTop10(Pageable pageable);

}