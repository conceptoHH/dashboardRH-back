package com.chaindrenciales.dashboardrh.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.BitacoraResponseDTO;
import com.chaindrenciales.dashboardrh.dto.BitacoraDetalleDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.chaindrenciales.dashboardrh.repositories.BitacoraRepository;

@Service
@Transactional(readOnly = true)
public class BitacoraRHService {

    private final BitacoraRepository bitacoraRepository;

    public BitacoraRHService(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }

    public List<BitacoraDetalleDTO> obtenerTop10Bitacora() {
        Pageable pageable = PageRequest.of(0, 10);
        return bitacoraRepository.obtenerTop10(pageable);
    }

    public Page<BitacoraResponseDTO> listarBitacora(
            Long empresaId, 
            LocalDate fechaInicio, 
            LocalDate fechaFin, 
            String accion, 
            Long usuarioId, 
            Pageable pageable) {

        return Page.empty(); 
    }

    public BitacoraResponseDTO obtenerPorId(Long bitacoraId) {

        BitacoraResponseDTO dto = new BitacoraResponseDTO();
        dto.setBitacoraId(bitacoraId);
        dto.setNombreUsuario("Usuario Ejemplo");
        dto.setAccion("ACCION_EJEMPLO");
        dto.setDescripcion("Descripción simulada");
        dto.setFechaAccion(java.time.LocalDateTime.now());
        dto.setEmpresaId(2L);

        return dto;
    }

    public Page<BitacoraResponseDTO> obtenerActividadReciente(Long empresaId, Pageable pageable) {
        return Page.empty();
    }
}