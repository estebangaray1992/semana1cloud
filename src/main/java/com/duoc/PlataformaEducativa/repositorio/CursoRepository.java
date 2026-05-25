package com.duoc.PlataformaEducativa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.PlataformaEducativa.entidad.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByNombre(String nombre);
}
