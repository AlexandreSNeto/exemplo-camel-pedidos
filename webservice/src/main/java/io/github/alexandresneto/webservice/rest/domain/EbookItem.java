package io.github.alexandresneto.webservice.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class EbookItem {

    private String formato;

    private int quantidade;

    private Ebook livro;

}
