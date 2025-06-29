package com.example.demo.Carrito.repositories;

import com.example.demo.Carrito.models.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
    Envio findById(long Id);
}
