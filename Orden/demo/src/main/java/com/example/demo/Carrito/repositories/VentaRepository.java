package com.example.demo.Carrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Carrito.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    Venta findById(long Id);
}
