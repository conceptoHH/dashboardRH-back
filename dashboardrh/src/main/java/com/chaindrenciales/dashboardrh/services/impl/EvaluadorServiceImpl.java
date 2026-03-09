/*package com.chaindrenciales.dashboardrh.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.DetalleEvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;
import com.chaindrenciales.dashboardrh.repositories.EvaluadorRepository;

@Service

public class EvaluadorServiceImpl implements EvaluadorService {

    private final EvaluadorRepository evaluadorRepository;

    public EvaluadorServiceImpl(EvaluadorRepository evaluadorRepository) {
        this.evaluadorRepository = evaluadorRepository;
    }

    public DetalleEvaluadorResponseDTO obtenerDetalleEvaluador(Long evaluadorId, Long empresaId) {

        // Datos básicos del evaluador
        DetalleEvaluadorResponseDTO detalle = evaluadorRepository.findDetalleEvaluadorBase(evaluadorId, empresaId)
                .orElseThrow(() -> new RuntimeException("Evaluador no encontrado"));

        // Reclutadores asociados
        List<ReclutadorResponseDTO> reclutadores = evaluadorRepository.findReclutadoresAsociados(evaluadorId, empresaId);
        detalle.setReclutadoresAsociados(reclutadores);

        // Aquí puedes agregar lógica real para:
        // - totalExamenesCalificados
        // - categoriasExpertise
        detalle.setTotalExamenesCalificados(0);
        detalle.setCategoriasExpertise(List.of()); // placeholder vacío

        return detalle;
    }
}*/