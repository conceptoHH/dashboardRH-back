package com.chaindrenciales.dashboardrh.services;


import org.springframework.stereotype.Service;


import com.chaindrenciales.dashboardrh.dto.ReclutadorEvaluadorResponseDTO;


@Service
public interface ReclutadorEvaluadorService {

    ReclutadorEvaluadorResponseDTO asignar(
            Long reclutadorId,
            Long evaluadorId,
            Long empresaId
    );

}
