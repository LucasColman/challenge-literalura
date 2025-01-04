package com.aluracursos.literalura.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int anioNacimiento;
    private int anioFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();


    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.anioNacimiento = datosAutor.anioNacimiento();
        this.anioFallecimiento = datosAutor.anioFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int getAnioFallecimiento() {
        return anioFallecimiento;
    }

    public void setAnioFallecimiento(int anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void addLibro(Libro libro){
        this.libros.add(libro);
    }

    public void deleteLibro(Libro libro){
        this.libros.remove(libro);
    }

    @Override
    public String toString() {
        StringBuilder librosString = new StringBuilder();
        if (libros != null && !libros.isEmpty()) {
            for (int i = 0; i < libros.size(); i++) {
                librosString.append("\n        ").append(i + 1).append(". ").append(libros.get(i).getTitulo());
            }
        } else {
            librosString.append("No hay libros disponibles.");
        }

        return
                " Información del Autor:" +
                "\n    Id: " + id +
                "\n    Nombre: " + nombre +
                "\n    Año de Nacimiento: " + anioNacimiento +
                "\n    Año de Fallecimiento: " + anioFallecimiento +
                "\n    Libros: " + librosString +
                "\n ****************************************** \n";
    }

}
