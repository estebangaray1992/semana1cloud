package com.duoc.PlataformaEducativa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.PlataformaEducativa.entidad.Inscripcion;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
