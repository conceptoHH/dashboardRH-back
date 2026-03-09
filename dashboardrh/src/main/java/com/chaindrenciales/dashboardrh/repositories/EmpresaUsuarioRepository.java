package com.chaindrenciales.dashboardrh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaindrenciales.dashboardrh.models.EmpresaUsuario;
import com.chaindrenciales.dashboardrh.models.RolCorporativo;

import java.util.List;
import java.util.Optional;

public interface EmpresaUsuarioRepository extends JpaRepository<EmpresaUsuario, Long> {

    // Buscar todas las relaciones por empresa
    List<EmpresaUsuario> findByEmpresaId(Long empresaId);

    // Buscar todos los usuarios de una empresa por rol
    List<EmpresaUsuario> findByEmpresaIdAndRolCorporativo(
            Long empresaId,
            RolCorporativo rol
    );

    // Buscar todos los líderes RH del sistema
    List<EmpresaUsuario> findByRolCorporativo(RolCorporativo rol);

    // Buscar relación específica usuario-empresa
    Optional<EmpresaUsuario> findByUsuarioIdAndEmpresaId(
            Long usuarioId,
            Long empresaId
    );

    // Validar si un usuario ya pertenece a la empresa
    boolean existsByUsuarioIdAndEmpresaId(
            Long usuarioId,
            Long empresaId
    );

    // Contar líderes RH por empresa (para no dejar empresa sin líder)
    long countByEmpresaIdAndRolCorporativo(
            Long empresaId,
            RolCorporativo rol
    );

    // Validar que un usuario pertenece a la empresa con un rol específico y está activo
    boolean existsByUsuarioIdAndEmpresaIdAndRolCorporativoAndActivo(
            Long usuarioId,
            Long empresaId,
            RolCorporativo rol,
            Boolean activo
    );
}