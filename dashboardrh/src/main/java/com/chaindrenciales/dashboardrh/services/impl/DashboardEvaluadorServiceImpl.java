package com.chaindrenciales.dashboardrh.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.DetalleEvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.EmpleadoResumenDTO;
import com.chaindrenciales.dashboardrh.models.EmpresaUsuario;
import com.chaindrenciales.dashboardrh.models.ReclutadorEvaluador;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.repositories.EmpresaUsuarioRepository;
import com.chaindrenciales.dashboardrh.repositories.EvaluadorRepository;
import com.chaindrenciales.dashboardrh.repositories.ReclutadorEvaluadorRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;
import com.chaindrenciales.dashboardrh.services.DashboardEvaluadorService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DashboardEvaluadorServiceImpl implements DashboardEvaluadorService {

    private final EvaluadorRepository evaluadorRepository;
    private final UsuarioRepository usuarioRepository;
    private final ReclutadorEvaluadorRepository reclutadorEvaluadorRepository;
    private final EmpresaUsuarioRepository empresaUsuarioRepository; // Aquí está el repositorio de EmpresaUsuario

    public DashboardEvaluadorServiceImpl(
            EvaluadorRepository evaluadorRepository,
            UsuarioRepository usuarioRepository,
            ReclutadorEvaluadorRepository reclutadorEvaluadorRepository,
            EmpresaUsuarioRepository empresaUsuarioRepository) {  // Inyectamos el repositorio
        this.evaluadorRepository = evaluadorRepository;
        this.usuarioRepository = usuarioRepository;
        this.reclutadorEvaluadorRepository = reclutadorEvaluadorRepository;
        this.empresaUsuarioRepository = empresaUsuarioRepository; // Guardamos la referencia
    }

    @Override
    public List<EvaluadorResponseDTO> obtenerEvaluadoresPorEmpresa(Long idEmpresa) {
        return evaluadorRepository.findDashboardEvaluadoresByEmpresa(idEmpresa);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleEvaluadorResponseDTO obtenerDetalleEvaluador(Long evaluadorId, Long empresaId) {

        DetalleEvaluadorResponseDTO detalle = usuarioRepository.findById(evaluadorId)
                .map(u -> {
                	
                    DetalleEvaluadorResponseDTO dto = new DetalleEvaluadorResponseDTO();
                    dto.setEvaluadorId(u.getId());
                    dto.setNombreCompleto(u.getNombre() + " " + u.getApellidos());
                    dto.setApellidos(u.getApellidos());
                    dto.setPuesto(u.getPuesto());
                    dto.setCorreoElectronico(u.getEmail());

                    EmpresaUsuario empresaUsuario = empresaUsuarioRepository
                            .findAll().stream()
                            .filter(eu -> eu.getUsuario().getId().equals(u.getId()))
                            .findFirst()
                            .orElseThrow(() -> new EntityNotFoundException("Evaluador no encontrado en ninguna empresa"));

                    dto.setEstado(empresaUsuario.getActivo());

                    return dto;

                   /* DetalleEvaluadorResponseDTO dto = new DetalleEvaluadorResponseDTO();
                    dto.setEvaluadorId(u.getId());
                    dto.setNombreCompleto(u.getNombre() + " " + u.getApellidos());
                    dto.setApellidos(u.getApellidos());
                    dto.setPuesto(u.getPuesto());
                    dto.setCorreoElectronico(u.getEmail());
                    dto.setEstado(true); 
                    //dto.setCandidatosPendientes(0); // opcional
                    return dto;*/
                })
                .orElseThrow(() -> new EntityNotFoundException("Evaluador no encontrado en esta empresa"));

        List<ReclutadorEvaluador> relaciones = reclutadorEvaluadorRepository
                .findByEvaluadorIdAndEmpresaId(evaluadorId, empresaId);

        
        List<EmpleadoResumenDTO> reclutadoresAsociados = relaciones.stream()
                .map(rel -> {
                    EmpleadoResumenDTO dto = new EmpleadoResumenDTO();
                    dto.setEmpleadoId(rel.getReclutador().getId()); 
                    dto.setNombreCompleto(rel.getReclutador().getNombre() + " " + rel.getReclutador().getApellidos());
                    dto.setPuesto(rel.getReclutador().getPuesto());
                    dto.setEstado(rel.getActivo());
                    dto.setFechaAsociacion(rel.getFechaAsignacion());
                    dto.setExamenesPendientes(0); 
                    return dto;
                })
                .collect(Collectors.toList());

        detalle.setReclutadores(reclutadoresAsociados);

        return detalle;
    }
    
    @Override
    @Transactional
    public void actualizarEstatus(Long evaluadorId, Boolean nuevoEstatus) {
        // Obtener todas las relaciones del evaluador en empresas
        List<EmpresaUsuario> relaciones = empresaUsuarioRepository
            .findAll().stream()
            .filter(eu -> eu.getUsuario().getId().equals(evaluadorId))
            .toList();

        if (relaciones.isEmpty()) {
            throw new EntityNotFoundException("Evaluador no encontrado en ninguna empresa");
        }

        for (EmpresaUsuario empresaUsuario : relaciones) {
            empresaUsuario.setActivo(nuevoEstatus);

            if (!nuevoEstatus) {
                empresaUsuario.setFechaDesactivacion(java.time.LocalDateTime.now());
            } else {
                empresaUsuario.setFechaDesactivacion(null);
            }

            empresaUsuarioRepository.save(empresaUsuario);
        }
    }
}