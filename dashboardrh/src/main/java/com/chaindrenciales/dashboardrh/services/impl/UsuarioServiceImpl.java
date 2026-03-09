
package com.chaindrenciales.dashboardrh.services.impl;


import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.CrearUsuarioDesdeInvitacionRequestDTO;
import com.chaindrenciales.dashboardrh.dto.RegistroUsuarioResponseDTO;
import com.chaindrenciales.dashboardrh.models.EstadoInvitacion;
import com.chaindrenciales.dashboardrh.models.InvitacionEmpresa;
import com.chaindrenciales.dashboardrh.models.Rol;
import com.chaindrenciales.dashboardrh.models.RolCorporativo;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.models.UsuarioRol;
import com.chaindrenciales.dashboardrh.repositories.InvitacionEmpresaRepository;
import com.chaindrenciales.dashboardrh.repositories.RolRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRolRepository;
import com.chaindrenciales.dashboardrh.services.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioRolRepository usuarioRolRepository;
    private final RolRepository rolRepository;
    private final InvitacionEmpresaRepository invitacionRepository;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            UsuarioRolRepository usuarioRolRepository,
            RolRepository rolRepository,
            InvitacionEmpresaRepository invitacionRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
        this.rolRepository = rolRepository;
        this.invitacionRepository = invitacionRepository;
    }

    @Override
    public RegistroUsuarioResponseDTO crearDesdeInvitacion(CrearUsuarioDesdeInvitacionRequestDTO dto) {

        // 1. Cargar invitación
        InvitacionEmpresa invitacion = invitacionRepository.findById(dto.getInvitacionId())
                .orElseThrow(() -> new RuntimeException("Invitación no encontrada"));

        // 2. Validar que esté pendiente
        if (invitacion.getEstado() != EstadoInvitacion.PENDIENTE) {
            throw new RuntimeException(
                    "La invitación no está en estado PENDIENTE (estado actual: " + invitacion.getEstado() + ")");
        }

        // 3. Validar que el email no esté registrado
        if (usuarioRepository.findByEmail(invitacion.getEmail()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario registrado con el email: " + invitacion.getEmail());
        }

        // 4. Validar que el username no esté en uso
        if (usuarioRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("El username '" + dto.getUsername() + "' ya está en uso");
        }

        // 5. Buscar el rol de plataforma correspondiente al rol corporativo
        String nombreRol = mapRolCorporativoANombreRol(invitacion.getRolCorporativo());
        Rol rol = rolRepository.findByNombreRol(nombreRol);
        if (rol == null) {
            throw new RuntimeException("Rol de plataforma no encontrado: " + nombreRol);
        }

        // 6. Crear el usuario con datos del request + datos precargados de la invitación
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEmail(invitacion.getEmail());           // precargado de la invitación
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setTelefono(dto.getTelefono());
        usuario.setEmpresa_id(invitacion.getEmpresa().getId()); // precargado de la invitación
        usuario.setEnabled(true);
        usuario.setEstado_verificacion(false);
        usuario.setFecha_registro(LocalDate.now());
        usuario.setPerfil_completo(false);
        usuario.setPerfil("NORMAL");
        usuario.setPuesto(dto.getPuesto());
        usuario.setCreado_por_id(invitacion.getCreadoPor().getId());

        Usuario saved = usuarioRepository.save(usuario);

        // 7. Asignar rol de plataforma
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(saved);
        usuarioRol.setRol(rol);
        usuarioRolRepository.save(usuarioRol);

        return new RegistroUsuarioResponseDTO(
                saved.getId(),
                saved.getNombre(),
                saved.getApellidos(),
                saved.getEmail(),
                saved.getUsername(),
                saved.getTelefono(),
                saved.getEmpresa_id(),
                saved.getFecha_registro(),
                saved.getPuesto(),
                nombreRol
        );
    }

    /**
     * Mapea el rol corporativo (contexto empresa) al nombre del rol de plataforma (tabla roles).
     * HR_ADMIN  → RH_ADMIN
     * RECLUTADOR → RECLUTADOR
     * EVALUADOR  → EVALUADOR
     */
    private String mapRolCorporativoANombreRol(RolCorporativo rolCorporativo) {
        return switch (rolCorporativo) {
            case HR_ADMIN -> "RH_ADMIN";
            case RECLUTADOR -> "RECLUTADOR";
            case EVALUADOR -> "EVALUADOR";
        };
    }
}

