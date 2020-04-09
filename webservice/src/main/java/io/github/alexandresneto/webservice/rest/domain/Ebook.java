package io.github.alexandresneto.webservice.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Ebook {

    private String codigo;

    private String titulo;

    private String tituloCurto;

    private String nomeAutor;

    private BigDecimal valorEbook;

    private BigDecimal valorImpresso;

}
