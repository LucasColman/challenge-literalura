package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.services.ConsumoAPI;
import com.aluracursos.literalura.services.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }



    public void mostrarMenu() {
        var opcion = 1;
        while (opcion != 0) {
            var menu = """
                    ***************************************************************************
                    Bienvenido a la biblioteca de literatura, por favor seleccione una opcion:
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados\s
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    ***************************************************************************
                    """;


            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Gracias por usar la biblioteca de literatura");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }

    }

    private ResultadosLibro getDatosLibro() {
		var jsonLibros = consumoAPI.obtenerDatos(URL_BASE);
        return conversor.obtenerDatos(jsonLibros, ResultadosLibro.class);
    }

    //Buscar libro por titulo
    private void buscarLibro() {
        System.out.println("Escribe el titulo del libro que deseas buscar");
        try{
            var tituloLibro = teclado.nextLine();
            var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+ tituloLibro.replace(" ","%20"));
            ResultadosLibro datosLibro = conversor.obtenerDatos(json, ResultadosLibro.class);

            Optional<DatosLibro> libroBuscado = datosLibro.resultados().stream()
                    .filter(l -> l.titulo().toLowerCase().contains(tituloLibro.toLowerCase()))
                    .findFirst();

            if(libroBuscado.isPresent()){
                System.out.println(libroBuscado.get());

                Optional<Libro> libroExistente = libroRepository.buscarPorTitulo(libroBuscado.get().titulo());
                if(libroExistente.isPresent()){
                    System.out.println("El libro ya se encuentra registrado");
                }else{
                    Libro libro = new Libro(libroBuscado.get());

                    DatosAutor datosAutor = libroBuscado.get().autores().get(0);
                    Autor autor = new Autor(datosAutor);
                    autor.addLibro(libro);

                    autorRepository.save(autor);
                    libro.setAutor(autor);
                    libroRepository.save(libro);
                }
            }else{
                System.out.println("No se encontro el libro");
            }
        }catch (Exception e){
            System.out.println("Error al buscar el libro");
        }

    }

    private void listarLibros() {
        libroRepository.findAll().forEach(System.out::println);
    }

    private void listarAutores() {
        autorRepository.findAll().forEach(System.out::println);
    }

    private void listarAutoresVivos() {
        System.out.println("Escribe el año que deseas buscar");
        var anio = teclado.nextInt();

        List<Autor> autoresVivos = autorRepository.buscarAutoresVivos(anio);
        if(autoresVivos.isEmpty()){
            System.out.println("No se encontraron autores vivos en el año " + anio);
        } else{
            System.out.println("Los autores vivos en el año " + anio + " son:\n");
            autoresVivos.forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("""
                \uD83D\uDCDA Búsqueda de libros por idioma \uD83C\uDF0D

                Por favor, selecciona el idioma en el que deseas buscar libros: \s
                es. Español \s
                en. Inglés \s
                fr. Francés \s
                de. Alemán \s
                Otro (especifica el idioma) \s

                Escribe el codigo correspondiente o el nombre del idioma:""");

        var idioma = teclado.nextLine();
        System.out.println("Los libros registrados en el idioma: " + idioma + " son:\n");

        List<Libro> librosPorIdioma = libroRepository.buscarPorIdioma(Idioma.fromString(idioma));
        if(librosPorIdioma.isEmpty()){
            System.out.println("No se encontraron libros en el idioma " + idioma);
        } else{
            librosPorIdioma.forEach(System.out::println);
        }

    }


}
