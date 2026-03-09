package com.chaindrenciales.dashboardrh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaindrenciales.dashboardrh.models.EstadoInvitacion;
import com.chaindrenciales.dashboardrh.models.InvitacionEmpresa;

import java.util.List;
import java.util.Optional;

public interface InvitacionEmpresaRepository extends JpaRepository<InvitacionEmpresa, Long> {


    // Buscar invitaciones por empresa
    List<InvitacionEmpresa> findByEmpresaId(Long empresaId);

    // Buscar invitaciones pendientes por empresa
    List<InvitacionEmpresa> findByEmpresaIdAndEstado(Long empresaId, EstadoInvitacion estado);

    // Validar si ya existe invitación pendiente para ese email y empresa
    boolean existsByEmailAndEmpresaIdAndEstado(
            String email,
            Long empresaId,
            EstadoInvitacion estado
    );
}