package com.duoc.PlataformaEducativa.servicio.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.PlataformaEducativa.dto.CursoRequestDTO;
import com.duoc.PlataformaEducativa.dto.CursoResponseDTO;
import com.duoc.PlataformaEducativa.entidad.Curso;
import com.duoc.PlataformaEducativa.exception.DuplicateResourceException;
import com.duoc.PlataformaEducativa.mapper.CursoMapper;
import com.duoc.PlataformaEducativa.repositorio.CursoRepository;
import com.duoc.PlataformaEducativa.servicio.CursoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public List<CursoResponseDTO> listarCursos() {

        List<Curso> cursos = cursoRepository.findAll();

        return CursoMapper.toResponseDTOList(cursos);
    }

    @Override
    public CursoResponseDTO crearCurso(CursoRequestDTO dto) {

        if (cursoRepository.existsByNombre(dto.getNombre())) {
            throw new DuplicateResourceException(
                    "Ya existe un curso con ese nombre"
            );
        }

        Curso curso = CursoMapper.toEntity(dto);

        Curso cursoGuardado = cursoRepository.save(curso);

        return CursoMapper.toResponseDTO(cursoGuardado);
    }
}
