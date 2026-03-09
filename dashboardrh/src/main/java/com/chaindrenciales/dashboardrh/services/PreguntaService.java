package com.chaindrenciales.dashboardrh.services;

import org.springframework.stereotype.Service;

import com.chaindrenciales.dashboardrh.models.Pregunta;
import com.chaindrenciales.dashboardrh.repositories.PreguntaRepository;


@Service
public class PreguntaService {

	  private final PreguntaRepository preguntaRepository;

	    public PreguntaService(PreguntaRepository preguntaRepository) {
	        this.preguntaRepository = preguntaRepository;
	    }

	    public Pregunta crearPregunta(Pregunta pregunta) {
	        return preguntaRepository.save(pregunta);
	    }
}