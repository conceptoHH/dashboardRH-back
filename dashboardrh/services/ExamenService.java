package com.chaindrenciales.dashboardrh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaindrenciales.dashboardrh.dto.ExamenRequestDTO;
import com.chaindrenciales.dashboardrh.enums.TipoExamen;
import com.chaindrenciales.dashboardrh.models.Categoria;
import com.chaindrenciales.dashboardrh.models.Examen;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.repositories.CategoriaVacanteRepository;
import com.chaindrenciales.dashboardrh.repositories.ExamenRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private CategoriaVacanteRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Examen crearExamen(ExamenRequestDTO dto) {

        Examen examen = new Examen();

        examen.setActivo(dto.getActivo());
        examen.setDescripcion(dto.getDescripcion());
        examen.setNumeroDePreguntas(dto.getNumeroDePreguntas());
        examen.setPuntosMaximos(dto.getPuntosMaximos());
        examen.setTitulo(dto.getTitulo());

        // --- Conversión de String a Enum ---
        if (dto.getTipoExamen() != null) {
            try {
                // Convierte el String a mayúsculas y luego a Enum
                TipoExamen tipo = TipoExamen.valueOf(dto.getTipoExamen().toUpperCase());
                examen.setTipoExamen(tipo);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Tipo de examen inválido: " + dto.getTipoExamen());
            }
        }

        // Relación Categoria
        if (dto.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada"));
            examen.setCategoria(categoria);
        }

        // Relación Evaluador
        if (dto.getEvaluadorId() != null) {
            Usuario evaluador = usuarioRepository.findById(dto.getEvaluadorId())
                .orElseThrow(() -> new IllegalArgumentException("Evaluador no encontrado"));
            examen.setEvaluador(evaluador);
        }

        // Relación Reclutador
        if (dto.getReclutadorId() != null) {
            Usuario reclutador = usuarioRepository.findById(dto.getReclutadorId())
                .orElseThrow(() -> new IllegalArgumentException("Reclutador no encontrado"));
            examen.setReclutador(reclutador);
        }

        return examenRepository.save(examen);
    }
    
    
    
}