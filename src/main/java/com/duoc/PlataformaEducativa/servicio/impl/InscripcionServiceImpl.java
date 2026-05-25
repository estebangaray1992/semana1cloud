package com.duoc.PlataformaEducativa.servicio.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.PlataformaEducativa.dto.InscripcionRequestDTO;
import com.duoc.PlataformaEducativa.dto.InscripcionResponseDTO;
import com.duoc.PlataformaEducativa.entidad.Curso;
import com.duoc.PlataformaEducativa.entidad.Inscripcion;
import com.duoc.PlataformaEducativa.entidad.Usuario;
import com.duoc.PlataformaEducativa.exception.ResourceNotFoundException;
import com.duoc.PlataformaEducativa.mapper.InscripcionMapper;
import com.duoc.PlataformaEducativa.repositorio.CursoRepository;
import com.duoc.PlataformaEducativa.repositorio.InscripcionRepository;
import com.duoc.PlataformaEducativa.repositorio.UsuarioRepository;
import com.duoc.PlataformaEducativa.servicio.InscripcionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    private final UsuarioRepository usuarioRepository;

    private final CursoRepository cursoRepository;

    @Override
    @Transactional
    public InscripcionResponseDTO crearInscripcion(
            InscripcionRequestDTO dto
    ) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Usuario no encontrado"
                        )
                );

        List<Curso> cursos = cursoRepository.findAllById(dto.getCursoIds());

        if (cursos.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No se encontraron cursos"
            );
        }

        Double total = cursos.stream()
                .mapToDouble(Curso::getCosto)
                .sum();

        Inscripcion inscripcion = new Inscripcion();

        inscripcion.setUsuario(usuario);
        inscripcion.setCursos(cursos);
        inscripcion.setFechaInscripcion(LocalDate.now());
        inscripcion.setTotal(total);

        Inscripcion inscripcionGuardada =
                inscripcionRepository.save(inscripcion);

        return InscripcionMapper.toResponseDTO(
                inscripcionGuardada
        );
    }

    @Override
    public List<InscripcionResponseDTO> listarInscripciones() {

        List<Inscripcion> inscripciones =
                inscripcionRepository.findAll();

        return InscripcionMapper.toResponseDTOList(
                inscripciones
        );
    }
}
