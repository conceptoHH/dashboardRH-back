package com.chaindrenciales.dashboardrh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaindrenciales.dashboardrh.models.Categoria;

@Repository
public interface CategoriaEvaluacionRepository extends JpaRepository<Categoria, Long> {

    // Devuelve todas las categorías ordenadas por categoriaId
    List<Categoria> findAllByOrderByCategoriaIdAsc();
}