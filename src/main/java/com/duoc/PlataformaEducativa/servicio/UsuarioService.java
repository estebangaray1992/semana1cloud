package com.duoc.PlataformaEducativa.servicio;

import java.util.List;

import com.duoc.PlataformaEducativa.dto.UsuarioRequestDTO;
import com.duoc.PlataformaEducativa.dto.UsuarioResponseDTO;

public interface UsuarioService {
    UsuarioResponseDTO crearUsuario(
            UsuarioRequestDTO dto
    );

    List<UsuarioResponseDTO> listarUsuarios();
}
