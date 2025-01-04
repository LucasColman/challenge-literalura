# LiterAlura

¡Bienvenido a **LiterAlura**! 📚

## Descripción del proyecto

**LiterAlura** es un proyecto pensado para gestionar y explorar un catálogo de libros personalizado. Este sistema realiza solicitudes a la API pública de libros **[Gutendex](https://gutendex.com/)**, manipula datos en formato JSON, los almacena en una base de datos, y permite filtrar y visualizar los libros y autores de interés directamente desde la consola.

## Características principales

- 🌐 **Consumo de API**: Realiza solicitudes a la API Gutendex para obtener información actualizada de libros.
- 🗃️ **Manejo de datos**: Procesa datos en formato JSON para estructurarlos y guardarlos de manera eficiente en una base de datos.
- 🔍 **Filtros personalizados**: Ofrece la posibilidad de filtrar por diferentes criterios, como idioma de los libros o autores vivos.  
- 📋 **Interfaz de consola**: Todo el sistema opera desde la consola, garantizando simplicidad y velocidad en las interacciones.

## Cómo funciona

1. **Solicitud a la API**: Se conecta a la API Gutendex para obtener un listado de libros y sus metadatos (título, autor, idioma, etc.).
2. **Procesamiento de datos**: Los datos JSON obtenidos son procesados y organizados.
3. **Almacenamiento**: La información se guarda en una base de datos para facilitar búsquedas futuras.
4. **Visualización**: Se filtran y muestran los libros y autores según los intereses del usuario.

## Tecnologías utilizadas

- **Lenguaje de programación**: Java
- **Base de datos**: POSTGRESQL
- **API de libros**: [Gutendex](https://gutendex.com/)
- **Manejo de JSON**: Librería  Jackson

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/LucasColman/challenge-literalura.git
   ```
2. Accede al directorio del proyecto:
   ```bash
   cd challenge-literalura
   ```
3. Configura tu entorno de desarrollo (asegúrate de tener Java y las librerías necesarias instaladas).
4. Ejecuta el proyecto desde tu IDE o terminal.

## Uso

1. Ejecuta el programa desde la consola.
2. Navega por las opciones para buscar libros por autor, idioma, o cualquier otro criterio implementado.
3. Visualiza los resultados directamente en la consola.

## Próximas mejoras

- 🚀 Crear una interfaz gráfica de usuario (GUI) para hacer el sistema más accesible.
- 🌟 Implementar recomendaciones basadas en las búsquedas del usuario.
- 📈 Generar informes estadísticos sobre los libros almacenados.

---

Desarrollado con 💙 para los amantes de la lectura. ¡Explora el maravilloso mundo de los libros con LiterAlura! 🌟

