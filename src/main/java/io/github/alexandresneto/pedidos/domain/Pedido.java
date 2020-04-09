package io.github.alexandresneto.pedidos.domain;

import lombok.Data;

@Data
public class Pedido {

    private Formato formato;

    private Integer quantidade;

    private Livro livro;

}
