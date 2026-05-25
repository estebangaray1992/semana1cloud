package com.duoc.PlataformaEducativa.mapper;

import com.duoc.PlataformaEducativa.dto.CursoRequestDTO;
import com.duoc.PlataformaEducativa.dto.CursoResponseDTO;
import com.duoc.PlataformaEducativa.entidad.Curso;

import java.util.List;

public class CursoMapper {

    public static Curso toEntity(CursoRequestDTO dto) {

        Curso curso = new Curso();

        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setInstructor(dto.getInstructor());
        curso.setDuracionHoras(dto.getDuracionHoras());
        curso.setCosto(dto.getCosto());

        return curso;
    }

    public static CursoResponseDTO toResponseDTO(Curso curso) {

        return new CursoResponseDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getDescripcion(),
                curso.getInstructor(),
                curso.getDuracionHoras(),
                curso.getCosto()
        );
    }

    public static List<CursoResponseDTO> toResponseDTOList(List<Curso> cursos) {

        return cursos.stream()
                .map(CursoMapper::toResponseDTO)
                .toList();
    }
}
