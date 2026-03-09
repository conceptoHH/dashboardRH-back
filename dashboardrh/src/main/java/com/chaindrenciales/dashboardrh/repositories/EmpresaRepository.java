package com.chaindrenciales.dashboardrh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaindrenciales.dashboardrh.models.Empresa;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    // Buscar empresa por RFC (evita duplicados fiscales)
    Optional<Empresa> findByRfc(String rfc);

    // Buscar empresa por nombre
    Optional<Empresa> findByNombre(String nombre);

    // Validar si existe empresa por RFC
    boolean existsByRfc(String rfc);
}