package com.chaindrenciales.dashboardrh.services.impl;

import org.springframework.stereotype.Service;

import com.chaindrenciales.dashboardrh.dto.ReclutadorEvaluadorResponseDTO;
import com.chaindrenciales.dashboardrh.models.Empresa;
import com.chaindrenciales.dashboardrh.models.ReclutadorEvaluador;
import com.chaindrenciales.dashboardrh.models.RolCorporativo;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.repositories.EmpresaRepository;
import com.chaindrenciales.dashboardrh.repositories.EmpresaUsuarioRepository;
import com.chaindrenciales.dashboardrh.repositories.ReclutadorEvaluadorRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;
import com.chaindrenciales.dashboardrh.services.ReclutadorEvaluadorService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReclutadorEvaluadorServiceImpl implements ReclutadorEvaluadorService {

    private final ReclutadorEvaluadorRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final EmpresaUsuarioRepository empresaUsuarioRepository;

    public ReclutadorEvaluadorServiceImpl(
            ReclutadorEvaluadorRepository repository,
            UsuarioRepository usuarioRepository,
            EmpresaRepository empresaRepository,
            EmpresaUsuarioRepository empresaUsuarioRepository
    ) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
        this.empresaUsuarioRepository = empresaUsuarioRepository;
    }

    @Override
    public ReclutadorEvaluadorResponseDTO asignar(
            Long reclutadorId,
            Long evaluadorId,
            Long empresaId
    ) {
        if (reclutadorId.equals(evaluadorId)) {
            throw new RuntimeException("El reclutador y el evaluador no pueden ser el mismo usuario");
        }

        if (!empresaUsuarioRepository.existsByUsuarioIdAndEmpresaIdAndRolCorporativoAndActivo(
                reclutadorId, empresaId, RolCorporativo.RECLUTADOR, true)) {
            throw new RuntimeException("El reclutador no pertenece a esta empresa con el rol RECLUTADOR activo");
        }

        if (!empresaUsuarioRepository.existsByUsuarioIdAndEmpresaIdAndRolCorporativoAndActivo(
                evaluadorId, empresaId, RolCorporativo.EVALUADOR, true)) {
            throw new RuntimeException("El evaluador no pertenece a esta empresa con el rol EVALUADOR activo");
        }

        if (repository.existsByReclutadorIdAndEvaluadorIdAndEmpresaId(reclutadorId, evaluadorId, empresaId)) {
            throw new RuntimeException("La relación reclutador-evaluador ya existe en esta empresa");
        }

        Usuario reclutador = usuarioRepository.getReferenceById(reclutadorId);
        Usuario evaluador = usuarioRepository.getReferenceById(evaluadorId);
        Empresa empresa = empresaRepository.getReferenceById(empresaId);
        // TEMPORAL: asignadoPor = usuario ID 1 hasta implementar autenticación
        Usuario asignadoPor = usuarioRepository.getReferenceById(1L);

        ReclutadorEvaluador relacion = new ReclutadorEvaluador();
        relacion.setReclutador(reclutador);
        relacion.setEvaluador(evaluador);
        relacion.setEmpresa(empresa);
        relacion.setAsignadoPor(asignadoPor);
        relacion.setActivo(true);

        ReclutadorEvaluador saved = repository.save(relacion);

        return new ReclutadorEvaluadorResponseDTO(
                saved.getId(),
                saved.getReclutador().getId(),
                saved.getEvaluador().getId(),
                saved.getEmpresa().getId(),
                saved.getActivo(),
                saved.getFechaAsignacion()
        );
    }
}