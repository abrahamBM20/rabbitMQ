package com.clouduno.emisor.mensaje;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.clouduno.emisor.config.RabbitConfig;
import com.clouduno.emisor.mensaje.models.Mensaje;
import com.clouduno.emisor.mensaje.repositories.MensajeRepository;

@Component
public class MensajeListener {

    private final MensajeRepository repo;

    public MensajeListener(MensajeRepository repo) {
        this.repo = repo;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void recibir(String message) {
        Mensaje m = repo.save(new Mensaje(message));
        System.out.println("Recibido: " + m.getId() + " | " + m.getFecha() + " | " + message);
    }

    @RabbitListener(queues = RabbitConfig.TEST_QUEUE)
    public void recibirTest(String message) {
        System.out.println("Recibido en test: " + message);
    }
}