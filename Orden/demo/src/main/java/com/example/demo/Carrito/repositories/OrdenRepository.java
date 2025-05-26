package com.example.demo.Carrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Carrito.models.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    Orden findById(int Id);

}
