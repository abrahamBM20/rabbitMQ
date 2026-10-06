package com.clouduno.emisor.mensaje.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mensaje {
    @Id private String id = UUID.randomUUID().toString();
    private String message;
    private LocalDateTime fecha = LocalDateTime.now();

    protected Mensaje() {}
    public Mensaje(String message) { this.message = message; }

    public String getId() { return id; }
    public String getMessage() { return message; }
    public LocalDateTime getFecha() { return fecha; }
    public void setId(String id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}