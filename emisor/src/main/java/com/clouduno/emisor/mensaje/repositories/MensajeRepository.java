package com.clouduno.emisor.mensaje.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clouduno.emisor.mensaje.models.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, String> {}