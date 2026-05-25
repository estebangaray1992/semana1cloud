package com.duoc.PlataformaEducativa.mapper;

import java.util.List;

import com.duoc.PlataformaEducativa.dto.UsuarioRequestDTO;
import com.duoc.PlataformaEducativa.dto.UsuarioResponseDTO;
import com.duoc.PlataformaEducativa.entidad.Usuario;

public class UsuarioMapper {
    
    public static Usuario toEntity(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());

        return usuario;
    }

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol()
        );
    }

    public static List<UsuarioResponseDTO> toResponseDTOList(List<Usuario> usuarios) {

        return usuarios.stream()
                .map(UsuarioMapper::toResponseDTO)
                .toList();
    }
}
