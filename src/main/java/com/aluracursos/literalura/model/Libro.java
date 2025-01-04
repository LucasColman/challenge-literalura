package com.aluracursos.literalura.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long idLibro;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private int numeroDescargas;


    public Libro(){

    }
    public Libro(DatosLibro datosLibro){
            this.idLibro = datosLibro.id();
            this.titulo = datosLibro.titulo();
            //this.autor = new Autor(datosLibro.autores().get(0));
            this.idioma= Idioma.fromString(datosLibro.idiomas().get(0));
            this.numeroDescargas = datosLibro.numeroDescargas();
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(int numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return  "- Id=" + idLibro +
                "\n - Titulo = '" + titulo + '\'' +
                "\n - Autor = " + this.autor.getNombre() +
                "\n - Idioma = " + idioma +
                "\n - Numero de descargas = " + numeroDescargas + "\n";
    }
}

