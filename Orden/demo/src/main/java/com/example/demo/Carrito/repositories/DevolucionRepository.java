package com.example.demo.Carrito.repositories;

import com.example.demo.Carrito.models.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {
    Devolucion findby(long id);
}
