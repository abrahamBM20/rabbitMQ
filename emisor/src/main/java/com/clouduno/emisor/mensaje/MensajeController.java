package com.clouduno.emisor.mensaje;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clouduno.emisor.config.RabbitConfig;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    private final RabbitTemplate rabbit;

    public record MensajeRequest(String message) {}

    public MensajeController(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @PostMapping
    public ResponseEntity<Void> enviar(@RequestBody MensajeRequest req) {
        // (exchange, routingKey, mensaje). En fanout la routing key se ignora, va ""
        rabbit.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", req.message());
        return ResponseEntity.accepted().build();
    }
}