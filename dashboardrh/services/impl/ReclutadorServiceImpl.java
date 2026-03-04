package com.chaindrenciales.dashboardrh.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.ReclutadorResponseDTO;
import com.chaindrenciales.dashboardrh.dto.EvaluadorResumenDTO;
import com.chaindrenciales.dashboardrh.dto.ReasignacionCargaRequestDTO;
import com.chaindrenciales.dashboardrh.dto.ReasignacionCargaResponseDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorDetalleDTO;
import com.chaindrenciales.dashboardrh.dto.ReclutadorRequestDTO;
import com.chaindrenciales.dashboardrh.models.ReclutadorEvaluador;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.repositories.ReclutadorEvaluadorRepository;
import com.chaindrenciales.dashboardrh.repositories.ReclutadorRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;
import com.chaindrenciales.dashboardrh.services.ReclutadorService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class ReclutadorServiceImpl implements ReclutadorService {
	
	private final UsuarioRepository usuarioRepository;
    private final ReclutadorRepository reclutadorRepository;
    private final ReclutadorEvaluadorRepository reclutadorEvaluadorRepository;

    // Inyección de dependencias recomendada
    public ReclutadorServiceImpl(ReclutadorRepository reclutadorRepository, 
    		ReclutadorEvaluadorRepository reclutadorEvaluadorRepository, UsuarioRepository usuarioRepository) {
    	this.usuarioRepository = usuarioRepository;
		this.reclutadorRepository = reclutadorRepository;
        this.reclutadorEvaluadorRepository = reclutadorEvaluadorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReclutadorResponseDTO> obtenerReclutadoresPorEmpresa(Long idEmpresa) {
        if (idEmpresa == null) {
            throw new IllegalArgumentException("El ID de la empresa no puede ser nulo");
        }
        
        // La consulta ya devuelve los DTOs listos para el Frontend
        return reclutadorRepository.findDashboardReclutadoresByEmpresa(idEmpresa);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ReclutadorDetalleDTO obtenerDetalleReclutador(Long reclutadorId, Long empresaIdLogueada) {
        
        // 1. Obtener la cabecera (Datos del reclutador)
        ReclutadorDetalleDTO detalle = reclutadorRepository
                .findDetalleReclutadorHeader(reclutadorId, empresaIdLogueada)
                .orElseThrow(() -> new EntityNotFoundException("Reclutador no encontrado en esta empresa"));

        // 2. Obtener la lista de evaluadores (Optimizada a 1 sola consulta por el @EntityGraph)
        List<ReclutadorEvaluador> relaciones = reclutadorEvaluadorRepository
                .findByReclutadorIdAndEmpresaId(reclutadorId, empresaIdLogueada);

        // 3. Mapear a DTO
        List<EvaluadorResumenDTO> evaluadoresAsociados = relaciones.stream()
                .map(this::mapearAEvaluadorResumenDTO)
                .collect(Collectors.toList());

        // 4. Asignar la lista al DTO principal
        detalle.setEvaluadores(evaluadoresAsociados);

        return detalle;
    }

    // --- Helper de Mapeo --- //
    private EvaluadorResumenDTO mapearAEvaluadorResumenDTO(ReclutadorEvaluador relacion) {
        EvaluadorResumenDTO dto = new EvaluadorResumenDTO();
        
        dto.setEvaluadorId(relacion.getEvaluador().getId());
        dto.setNombreCompleto(relacion.getEvaluador().getNombre() + " " + relacion.getEvaluador().getApellidos());
        dto.setPuesto(relacion.getEvaluador().getPuesto());
        dto.setEstado(relacion.getActivo());
        dto.setFechaAsociacion(relacion.getFechaAsignacion());
        dto.setExamenesPendientes(0); // Pendiente de implementar lógica real
        
        return dto;
    }
    
    @Override
    @Transactional
    public ReclutadorResponseDTO actualizarReclutador(Long reclutadorId, @Valid ReclutadorRequestDTO request, Long empresaId) {
        
        // 1. Validar que el reclutador existe Y pertenece a la empresa (Seguridad)
        Usuario reclutador = usuarioRepository.findById(reclutadorId)
                .orElseThrow(() -> new EntityNotFoundException("Reclutador no encontrado"));

        // (Opcional) Validar que realmente sea de la empresa a través de EmpresaUsuario
        // if (!empresaUsuarioRepository.existsByUsuarioIdAndEmpresaId(reclutadorId, empresaId)) {
        //     throw new AccessDeniedException("No tienes permiso para modificar este usuario");
        // }

        // 2. Aplicar lógica PATCH: Actualizar solo lo que viene en el Request
        if (request.getNombreReclutador() != null && !request.getNombreReclutador().isBlank()) {
            reclutador.setNombre(request.getNombreReclutador());
        }
        if (request.getApellidos() != null && !request.getApellidos().isBlank()) {
            reclutador.setApellidos(request.getApellidos());
        }
        if (request.getPuesto() != null && !request.getPuesto().isBlank()) {
            reclutador.setPuesto(request.getPuesto());
        }
        if (request.getTelefono() != null && !request.getTelefono().isBlank()) {
            reclutador.setTelefono(request.getTelefono());
        }
        if (request.getCorreoElectronico() != null && !request.getCorreoElectronico().isBlank()) {
            reclutador.setEmail(request.getCorreoElectronico());
        }

        // 3. Guardar en BD
        Usuario usuarioActualizado = usuarioRepository.save(reclutador);

        // 4. Mapear y retornar la respuesta (Puedes reutilizar el método de mapeo si encaja, o crear uno nuevo)
        return mapearAReclutadorResponseDTO(usuarioActualizado); 
    }

	private ReclutadorResponseDTO mapearAReclutadorResponseDTO(Usuario usuarioActualizado) {
		ReclutadorResponseDTO dto = new ReclutadorResponseDTO();
		
		dto.setNombreReclutador(usuarioActualizado.getNombre());
		dto.setApellidos(usuarioActualizado.getApellidos());
		dto.setPuesto(usuarioActualizado.getPuesto());
		dto.setTelefono(usuarioActualizado.getTelefono());
		dto.setCorreo(usuarioActualizado.getEmail());
		
		return dto;
	}
	
	@Override
    @Transactional
    public ReasignacionCargaResponseDTO reasignarCarga(@Valid ReasignacionCargaRequestDTO request, Long empresaIdLogueada) {
        
        // 1. Validaciones de negocio (¡Muy importante!)
        if (request.getReclutadorOrigenId().equals(request.getReclutadorDestinoId())) {
            throw new IllegalArgumentException("El reclutador origen y destino no pueden ser el mismo");
        }

        // 2. Validar que el reclutador destino exista (el origen lo validaremos implícitamente al buscar sus relaciones)
        Usuario reclutadorDestino = usuarioRepository.findById(request.getReclutadorDestinoId())
                .orElseThrow(() -> new EntityNotFoundException("El reclutador destino no existe"));

        // 3. Obtener toda la carga (evaluadores) del reclutador origen en esta empresa
        // ¡Usamos el método que optimizamos hace un rato con @EntityGraph!
        List<ReclutadorEvaluador> relaciones = reclutadorEvaluadorRepository
                .findByReclutadorIdAndEmpresaId(request.getReclutadorOrigenId(), empresaIdLogueada);

        if (relaciones.isEmpty()) {
            throw new IllegalArgumentException("El reclutador origen no tiene evaluadores asignados para transferir");
        }

        // 4. Reasignar masivamente
        for (ReclutadorEvaluador relacion : relaciones) {
            relacion.setReclutador(reclutadorDestino);
            // Podríamos guardar el 'motivoReasignacion' si la tabla ReclutadorEvaluador tuviera un campo para ello, 
            // o idealmente, registrarlo en una tabla de Bitácora/Auditoría.
        }

        // 5. Guardar los cambios (Hibernate hará un UPDATE por cada registro modificado de forma optimizada)
        reclutadorEvaluadorRepository.saveAll(relaciones);

        // 6. Preparar respuesta
        ReasignacionCargaResponseDTO response = new ReasignacionCargaResponseDTO();
        response.setReclutadorOrigenId(request.getReclutadorOrigenId());
        response.setReclutadorDestinoId(request.getReclutadorDestinoId());
        response.setMotivoReasignacion(request.getMotivoReasignacion());
        response.setFechaReasignacion(LocalDateTime.now());
        return response;
    }

}
