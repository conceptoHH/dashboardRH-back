package com.chaindrenciales.dashboardrh.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.EmpresaUsuarioResponseDTO;
import com.chaindrenciales.dashboardrh.models.Empresa;
import com.chaindrenciales.dashboardrh.models.EmpresaUsuario;
import com.chaindrenciales.dashboardrh.models.RolCorporativo;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.repositories.EmpresaRepository;
import com.chaindrenciales.dashboardrh.repositories.EmpresaUsuarioRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRolRepository;
import com.chaindrenciales.dashboardrh.services.EmpresaUsuarioService;

@Service
@Transactional
public class EmpresaUsuarioServiceImpl implements EmpresaUsuarioService {

    private final EmpresaUsuarioRepository empresaUsuarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    public EmpresaUsuarioServiceImpl(
            EmpresaUsuarioRepository empresaUsuarioRepository,
            UsuarioRepository usuarioRepository,
            EmpresaRepository empresaRepository,
            UsuarioRolRepository usuarioRolRepository
    ) {
        this.empresaUsuarioRepository = empresaUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
        this.usuarioRolRepository = usuarioRolRepository;
    }

    @Override
    public EmpresaUsuarioResponseDTO asociarUsuarioAEmpresa(
            Long usuarioId,
            Long empresaId,
            RolCorporativo rol
    ) {
        if (empresaUsuarioRepository.existsByUsuarioIdAndEmpresaId(usuarioId, empresaId)) {
            throw new RuntimeException("El usuario ya pertenece a esta empresa");
        }

        Usuario usuario = usuarioRepository.getReferenceById(usuarioId);
        Empresa empresa = empresaRepository.getReferenceById(empresaId);
        // TEMPORAL: asignadoPor = usuario ID 1 hasta implementar autenticación
        Usuario asignadoPor = usuarioRepository.getReferenceById(1L);

        EmpresaUsuario empresaUsuario = new EmpresaUsuario();
        empresaUsuario.setUsuario(usuario);
        empresaUsuario.setEmpresa(empresa);
        empresaUsuario.setRolCorporativo(rol);
        empresaUsuario.setActivo(true);
        empresaUsuario.setAsignadoPor(asignadoPor);

        EmpresaUsuario saved = empresaUsuarioRepository.save(empresaUsuario);

        return new EmpresaUsuarioResponseDTO(
                saved.getId(),
                saved.getUsuario().getId(),
                saved.getEmpresa().getId(),
                saved.getRolCorporativo().name(),
                saved.getActivo(),
                saved.getFechaAsignacion()
        );
    }

    @Override
    public EmpresaUsuarioResponseDTO crearAdminRh(Long adminId, Long usuarioId, Long empresaId) {
        boolean esAdmin = usuarioRolRepository.existsByUsuarioIdAndRolNombre(adminId, "ADMIN");
        if (!esAdmin) {
            throw new RuntimeException("El usuario solicitante no tiene permisos de administrador");
        }

        if (empresaUsuarioRepository.existsByUsuarioIdAndEmpresaId(usuarioId, empresaId)) {
            throw new RuntimeException("El usuario ya pertenece a esta empresa");
        }

        Usuario usuario = usuarioRepository.getReferenceById(usuarioId);
        Empresa empresa = empresaRepository.getReferenceById(empresaId);
        Usuario asignadoPor = usuarioRepository.getReferenceById(adminId);

        EmpresaUsuario empresaUsuario = new EmpresaUsuario();
        empresaUsuario.setUsuario(usuario);
        empresaUsuario.setEmpresa(empresa);
        empresaUsuario.setRolCorporativo(RolCorporativo.HR_ADMIN);
        empresaUsuario.setActivo(true);
        empresaUsuario.setAsignadoPor(asignadoPor);

        EmpresaUsuario saved = empresaUsuarioRepository.save(empresaUsuario);

        return new EmpresaUsuarioResponseDTO(
                saved.getId(),
                saved.getUsuario().getId(),
                saved.getEmpresa().getId(),
                saved.getRolCorporativo().name(),
                saved.getActivo(),
                saved.getFechaAsignacion()
        );
    }
}
