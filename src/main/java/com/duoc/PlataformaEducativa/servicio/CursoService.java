package com.duoc.PlataformaEducativa.servicio;

import java.util.List;

import com.duoc.PlataformaEducativa.dto.CursoRequestDTO;
import com.duoc.PlataformaEducativa.dto.CursoResponseDTO;

public interface CursoService {

    List<CursoResponseDTO> listarCursos();

    CursoResponseDTO crearCurso(CursoRequestDTO dto);
}
