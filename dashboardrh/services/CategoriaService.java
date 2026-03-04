package com.chaindrenciales.dashboardrh.services;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chaindrenciales.dashboardrh.dto.CategoriaRequestDTO;
import com.chaindrenciales.dashboardrh.dto.CategoriaVacanteResponseDTO;
import com.chaindrenciales.dashboardrh.models.Categoria;
import com.chaindrenciales.dashboardrh.models.Usuario;
import com.chaindrenciales.dashboardrh.repositories.CategoriaVacanteRepository;
import com.chaindrenciales.dashboardrh.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoriaService {

    private final CategoriaVacanteRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository; // inyección por campo para evitar duplicidad

    public CategoriaService(CategoriaVacanteRepository repository) {
        this.repository = repository;
    }
    
    public List<CategoriaVacanteResponseDTO> obtenerCategoriasActivas() {
        return null;
    }
 

        public Categoria guardar(CategoriaRequestDTO dto) {

            Categoria categoria = new Categoria();

            // Asignar solo el ID sin hacer SELECT
            Usuario reclutador = new Usuario();
            reclutador.setId(dto.getReclutadorId()); // 👈 CAMBIO AQUÍ
            categoria.setReclutador(reclutador);

            categoria.setBeneficios(dto.getBeneficios());
            categoria.setCargo(dto.getCargo());
            categoria.setDescripcionPuesto(dto.getDescripcionPuesto());
            categoria.setEstado(dto.getEstado());

            if (dto.getFecha_publicacion() != null) {
                Date fecha = Date.from(
                    dto.getFecha_publicacion()
                       .atZone(ZoneId.systemDefault())
                       .toInstant()
                );
                categoria.setFechaPublicacion(fecha);
            }

            categoria.setFrecuenciaPago(dto.getFrecuencia_pago());
            categoria.setMoneda(dto.getMoneda());
            categoria.setNivelExperiencia(dto.getNivel_experiencia());
            categoria.setRequisitos(dto.getRequisitos());
            categoria.setSueldoMaximo(dto.getSueldo_maximo());
            categoria.setSueldoMinimo(dto.getSueldo_minimo());
            categoria.setTipoEmpleo(dto.getTipo_empleo());
            categoria.setTipoLugarTrabajo(dto.getTipo_lugar_trabajo());
            categoria.setUbicacion(dto.getUbicacion());
            categoria.setAmbitoLaboral(dto.getAmbito_laboral());
            categoria.setDispuestoReubicacion(dto.getDispuesto_reubicacion());
            categoria.setTecnologiaPrincipal(dto.getTecnologia_principal());
            categoria.setIdiomas(dto.getIdiomas());
            categoria.setTecnologiasSecundarias(dto.getTecnologias_secundarias());

            return repository.save(categoria);

        }
    	
}