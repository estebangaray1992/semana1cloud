package com.duoc.PlataformaEducativa.dto;

import com.duoc.PlataformaEducativa.entidad.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;

    private String nombre;

    private String correo;

    private Rol rol;
}
