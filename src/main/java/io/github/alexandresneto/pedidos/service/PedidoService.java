package io.github.alexandresneto.pedidos.service;

import io.github.alexandresneto.pedidos.domain.Pedido;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpMethods;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:pedidos").
        routeId("rota-pedidos").
                multicast().
                to("direct:http-post").
                to("direct:http-get");

        from("direct:http-post").
                routeId("rota-http-post").
                split().xpath("/pedido/itens/item").
                filter().xpath("/item/formato[text()='EBOOK']").
                unmarshal().jacksonxml(Pedido.class).
                marshal().json().
                log("Enviando pedido para API via HTTP POST").
                setHeader(Exchange.CONTENT_TYPE, constant("application/json")).
                to("http://localhost:8080/ebook/item");

        from("direct:http-get").
                routeId("rota-http-get").
                setProperty("pedidoId", xpath("/pedido/id/text()")).
                setProperty("clientId", xpath("/pedido/pagamento/email-titular/text()")).
                split().xpath("/pedido/itens/item").
                filter().xpath("/item/formato[text()='EBOOK']").
                setProperty("ebookId", xpath("/item/livro/codigo/text()")).
                log("Realizando chamada à API de pedidos via HTTP GET").
                setHeader(Exchange.HTTP_METHOD, HttpMethods.GET).
                setHeader(Exchange.HTTP_QUERY, simple("pedidoId=${exchangeProperty.pedidoId}&clientId=${exchangeProperty.clientId}&ebookId=${exchangeProperty.ebookId}")).
                to("http://localhost:8080/ebook/item");
    }

}
