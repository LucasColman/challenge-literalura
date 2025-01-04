package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Idioma;
import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:nombreLibro%")
    Optional<Libro> buscarPorTitulo(String nombreLibro);

    @Query("select l from Libro l where l.idioma = :idioma")
    List<Libro> buscarPorIdioma(Idioma idioma);
}
