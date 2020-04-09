package io.github.alexandresneto.webservice.rest;


import io.github.alexandresneto.webservice.rest.domain.EbookItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ebook/item")
@Slf4j
public class EbookItemRest {

    @PostMapping
    public void salvarItem(@RequestBody EbookItem item) {
        log.info("-----------------------------");
        log.info("-------- SALVAR ITEM --------");
        log.info(item.toString());
    }

    // http://localhost:8080/ebook/item?pedidoId=111&clientId=aaa&ebookId=bbb
    @GetMapping
    public void obterItem(@RequestParam Long pedidoId, @RequestParam String clientId, @RequestParam String ebookId) {
        log.info("-----------------------------");
        log.info("-------- OBTER ITEM ---------");
        log.info("PedidoId: {}", pedidoId);
        log.info("ClientId: {}", clientId);
        log.info("EbookId: {}", ebookId);
    }

}
