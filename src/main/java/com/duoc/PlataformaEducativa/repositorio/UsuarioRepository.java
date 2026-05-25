package com.duoc.PlataformaEducativa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.PlataformaEducativa.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    boolean existsByCorreo(String correo);
}
