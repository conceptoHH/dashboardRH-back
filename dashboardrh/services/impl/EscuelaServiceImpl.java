/*package com.chaindrenciales.vinculacion.services.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaindrenciales.vinculacion.dto.EscuelaRequestDTO;
import com.chaindrenciales.vinculacion.dto.EscuelaResponseDTO;
import com.chaindrenciales.vinculacion.mappers.EscuelaMapper;
import com.chaindrenciales.vinculacion.models.Escuela;
import com.chaindrenciales.vinculacion.repositories.EscuelaCarreraRepository;
import com.chaindrenciales.vinculacion.repositories.EscuelaRepository;
import com.chaindrenciales.vinculacion.services.EscuelaService;

@Service
public class EscuelaServiceImpl implements EscuelaService {

	@Autowired
	private EscuelaRepository escuelaRepository;
	
	@Autowired
	private EscuelaCarreraRepository escuelaCarreraRepository;
	
	@Autowired
	private EscuelaMapper escuelaMapper;
	
	@Override
	public EscuelaResponseDTO getPerfilEscuelaById(Long escuelaId) {
		List<Object[]> tablaPerfilEscuela = escuelaRepository.getPerfilEscuelaById(escuelaId);
		Object[] fila = tablaPerfilEscuela.get(0);
		return new EscuelaResponseDTO(
                ((String) fila[0]),
                ((String) fila[1]),
                ((String) fila[2]),
                ((String) fila[3]),
                ((String) fila[4]),
                ((String) fila[5]),
                ((Timestamp) fila[6]),
                ((Number) fila[7]).longValue()
        );
	}

	@Override
	public void updatePerfilEscuelaById(Long escuelaId, EscuelaRequestDTO perfilActualizado) {
		Escuela perfil = escuelaRepository.findById(escuelaId).orElseThrow();
		escuelaMapper.toEntity(perfil, perfilActualizado);
		escuelaRepository.save(perfil);
	}

	@Override
	public String[] getCarreras(Long escuelaId) {
		return escuelaCarreraRepository.findCarreraNombreByEscuelaId(escuelaId);
	}
	
    /*
    public EscuelaResponseDTO crear(EscuelaRequestDTO dto) {
        Escuela escuela = new Escuela();
        escuela.setNombre(dto.getNombre());
        escuela.setCiudad(dto.getCiudad());
        escuela.setEstado(dto.getEstado());
        escuela.setPais(dto.getPais());

        escuelaRepository.save(escuela);
        return mapToDTO(escuela);
    }

    public List<EscuelaResponseDTO> listarTodas() {
        return escuelaRepository.findAll().stream()
            .map(this::mapToDTO)
            .toList();
    }

    public Optional<EscuelaResponseDTO> obtenerPorId(Long id) {
        return escuelaRepository.findById(id)
            .map(this::mapToDTO);
    }

    private EscuelaResponseDTO mapToDTO(Escuela escuela) {
        EscuelaResponseDTO dto = new EscuelaResponseDTO();
        dto.setId(escuela.getId());
        dto.setNombre(escuela.getNombre());
        dto.setCiudad(escuela.getCiudad());
        dto.setEstado(escuela.getEstado());
        dto.setPais(escuela.getPais());
        return dto;
    }
    public void eliminarPorId(Long id) {
        escuelaRepository.deleteById(id);
    }
    
    public Optional<EscuelaResponseDTO> actualizar(Long id, EscuelaRequestDTO dto) {
        return escuelaRepository.findById(id).map(escuela -> {
            escuela.setNombre(dto.getNombre());
            escuela.setCiudad(dto.getCiudad());
            escuela.setEstado(dto.getEstado());
            escuela.setPais(dto.getPais());
            escuelaRepository.save(escuela);

            EscuelaResponseDTO response = new EscuelaResponseDTO();
            response.setId(escuela.getId());
            response.setNombre(escuela.getNombre());
            response.setCiudad(escuela.getCiudad());
            response.setEstado(escuela.getEstado());
            response.setPais(escuela.getPais());

            return response;
        });
    }
    
    public ResponseEntity<List<EscuelaResponseDTO>> getDashboard() {
    	UsuarioEnum usuario_perfil = UsuarioEnum.AdminChaindrenciales;
    	
    	Long id = 2L;
    	//Obtiene un administrador institucional
    	Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe el usuario"));
    	
    	switch (usuario_perfil) {
			case AdminInstitucional: return ResponseEntity.ok(escuelaRepository.getDashboard(usuario));
			case AdminChaindrenciales: return ResponseEntity.ok(escuelaRepository.getDashboard(null));
			default: return new ResponseEntity<List<EscuelaResponseDTO>>(HttpStatus.FORBIDDEN);
    	}
    }
    
}*/


