package com.chaindrenciales.dashboardrh.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import com.chaindrenciales.dashboardrh.dto.InvitacionEmpresaResponseDTO;
import com.chaindrenciales.dashboardrh.models.*;
import com.chaindrenciales.dashboardrh.repositories.*;
import com.chaindrenciales.dashboardrh.services.InvitacionEmpresaService;

@Service
@Transactional
public class InvitacionEmpresaServiceImpl implements InvitacionEmpresaService {

    private final UsuarioRepository usuarioRepository;
    private final InvitacionEmpresaRepository invitacionRepository;
    private final EmpresaRepository empresaRepository;
    private final EmpresaUsuarioRepository empresaUsuarioRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    public InvitacionEmpresaServiceImpl(
            UsuarioRepository usuarioRepository,
            InvitacionEmpresaRepository invitacionRepository,
            EmpresaRepository empresaRepository,
            EmpresaUsuarioRepository empresaUsuarioRepository,
            UsuarioRolRepository usuarioRolRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.invitacionRepository = invitacionRepository;
        this.empresaRepository = empresaRepository;
        this.empresaUsuarioRepository = empresaUsuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
    }

    @Override
    public InvitacionEmpresaResponseDTO crearInvitacion(
            String nombre,
            String email,
            Long empresaId,
            RolCorporativo rol
    ) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        // TEMPORAL: creador = usuario ID 1 hasta implementar autenticación
        Usuario creador = usuarioRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuario creador no encontrado"));

        InvitacionEmpresa invitacion = new InvitacionEmpresa();
        invitacion.setNombre(nombre);
        invitacion.setEmail(email);
        invitacion.setEmpresa(empresa);
        invitacion.setRolCorporativo(rol);
        invitacion.setEstado(EstadoInvitacion.PENDIENTE);
        invitacion.setCreadoPor(creador);

        InvitacionEmpresa saved = invitacionRepository.save(invitacion);
        return toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public InvitacionEmpresaResponseDTO obtenerPorId(Long id) {
        InvitacionEmpresa inv = invitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitación no encontrada"));
        return toDTO(inv);
    }

    @Override
    public InvitacionEmpresaResponseDTO aceptarInvitacion(Long id) {
        InvitacionEmpresa invitacion = invitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitación no encontrada"));

        if (invitacion.getEstado() != EstadoInvitacion.PENDIENTE) {
            throw new RuntimeException("La invitación no está en estado PENDIENTE (estado actual: " + invitacion.getEstado() + ")");
        }

        Usuario usuario = usuarioRepository.findByEmail(invitacion.getEmail())
                .orElseThrow(() -> new RuntimeException(
                        "No existe un usuario registrado con el email: " + invitacion.getEmail()));

        Long empresaId = invitacion.getEmpresa().getId();

        if (empresaUsuarioRepository.existsByUsuarioIdAndEmpresaId(usuario.getId(), empresaId)) {
            throw new RuntimeException("El usuario ya pertenece a esta empresa");
        }

        EmpresaUsuario empresaUsuario = new EmpresaUsuario();
        empresaUsuario.setUsuario(usuario);
        empresaUsuario.setEmpresa(invitacion.getEmpresa());
        empresaUsuario.setRolCorporativo(invitacion.getRolCorporativo());
        empresaUsuario.setActivo(true);
        empresaUsuario.setAsignadoPor(invitacion.getCreadoPor());
        empresaUsuarioRepository.save(empresaUsuario);

        invitacion.setEstado(EstadoInvitacion.ACEPTADA);
        invitacion.setFechaAceptacion(LocalDateTime.now());
        InvitacionEmpresa saved = invitacionRepository.save(invitacion);

        return toDTO(saved);
    }

    @Override
    public InvitacionEmpresaResponseDTO crearInvitacionHrAdmin(
            Long adminId, String nombre, String email, Long empresaId
    ) {
        if (!usuarioRolRepository.existsByUsuarioIdAndRolNombre(adminId, "ADMIN")) {
            throw new RuntimeException("Solo un usuario con rol ADMIN puede invitar a un HR_ADMIN");
        }

        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        if (invitacionRepository.existsByEmailAndEmpresaIdAndEstado(email, empresaId, EstadoInvitacion.PENDIENTE)) {
            throw new RuntimeException("Ya existe una invitación pendiente para ese email en esta empresa");
        }

        Usuario admin = usuarioRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin no encontrado"));

        InvitacionEmpresa invitacion = new InvitacionEmpresa();
        invitacion.setNombre(nombre);
        invitacion.setEmail(email);
        invitacion.setEmpresa(empresa);
        invitacion.setRolCorporativo(RolCorporativo.HR_ADMIN);
        invitacion.setEstado(EstadoInvitacion.PENDIENTE);
        invitacion.setCreadoPor(admin);

        return toDTO(invitacionRepository.save(invitacion));
    }

    private InvitacionEmpresaResponseDTO toDTO(InvitacionEmpresa inv) {
        return new InvitacionEmpresaResponseDTO(
                inv.getId(),
                inv.getNombre(),
                inv.getEmail(),
                inv.getEmpresa().getId(),
                inv.getRolCorporativo().name(),
                inv.getEstado().name()
        );
    }
}