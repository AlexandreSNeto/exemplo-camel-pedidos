package io.github.alexandresneto.pedidos.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Livro {

    private String codigo;

    private String titulo;

    private String tituloCurto;

    private String nomeAutor;

    private BigDecimal valorEbook;

    private BigDecimal valorImpresso;

}
