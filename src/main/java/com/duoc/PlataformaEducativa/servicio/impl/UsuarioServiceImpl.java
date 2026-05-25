package com.duoc.PlataformaEducativa.servicio.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.PlataformaEducativa.dto.UsuarioRequestDTO;
import com.duoc.PlataformaEducativa.dto.UsuarioResponseDTO;
import com.duoc.PlataformaEducativa.entidad.Usuario;
import com.duoc.PlataformaEducativa.exception.DuplicateResourceException;
import com.duoc.PlataformaEducativa.mapper.UsuarioMapper;
import com.duoc.PlataformaEducativa.repositorio.UsuarioRepository;
import com.duoc.PlataformaEducativa.servicio.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDTO crearUsuario(
            UsuarioRequestDTO dto
    ) {

        if (usuarioRepository.existsByCorreo(dto.getCorreo())) {

            throw new DuplicateResourceException(
                    "El correo ya está registrado"
            );
        }

        Usuario usuario = UsuarioMapper.toEntity(dto);

        Usuario usuarioGuardado =
                usuarioRepository.save(usuario);

        return UsuarioMapper.toResponseDTO(
                usuarioGuardado
        );
    }

    @Override
    public List<UsuarioResponseDTO> listarUsuarios() {

        List<Usuario> usuarios =
                usuarioRepository.findAll();

        return UsuarioMapper.toResponseDTOList(
                usuarios
        );
    }
}
