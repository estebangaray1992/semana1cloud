package com.duoc.PlataformaEducativa.servicio;

import java.util.List;

import com.duoc.PlataformaEducativa.dto.InscripcionRequestDTO;
import com.duoc.PlataformaEducativa.dto.InscripcionResponseDTO;

public interface InscripcionService {
    InscripcionResponseDTO crearInscripcion(
            InscripcionRequestDTO dto
    );

    List<InscripcionResponseDTO> listarInscripciones();
}
