package com.aluracursos.literalura.model;

public enum Idioma {
    INGLES("en"),
    ESPANOL("es"),
    FRANCES("fr"),
    ITALIANO("it"),
    PORTUGUES("pt"),
    ALEMAN("de"),
    RUSO("ru"),
    CHINO("zh"),
    JAPONES("ja"),
    COREANO("ko"),
    ARABE("ar"),
    FINLANDES("fi");


    private String codigo;

    Idioma(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.codigo.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + text);
    }
}
