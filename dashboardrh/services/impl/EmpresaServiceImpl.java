package com.chaindrenciales.dashboardrh.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaindrenciales.dashboardrh.dto.EmpresaRequestDTO;
import com.chaindrenciales.dashboardrh.dto.EmpresaResponseDTO;
import com.chaindrenciales.dashboardrh.models.Empresa;
import com.chaindrenciales.dashboardrh.repositories.EmpresaRepository;
import com.chaindrenciales.dashboardrh.services.EmpresaService;

@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public EmpresaResponseDTO crearEmpresa(EmpresaRequestDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setNombre(dto.getNombre());
        empresa.setRazonSocial(dto.getRazonSocial());
        empresa.setRfc(dto.getRfc());
        empresa.setTelefono(dto.getTelefono());
        empresa.setDireccion(dto.getDireccion());
        return toDTO(empresaRepository.save(empresa));
    }

    @Override
    @Transactional(readOnly = true)
    public EmpresaResponseDTO obtenerPorId(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        return toDTO(empresa);
    }

    private EmpresaResponseDTO toDTO(Empresa e) {
        return new EmpresaResponseDTO(
                e.getId(), e.getNombre(), e.getRazonSocial(),
                e.getRfc(), e.getTelefono(), e.getDireccion(), e.isPlanActivo()
        );
    }
}