package com.example.demo.Carrito.repositories;

import com.example.demo.Carrito.models.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponRepository extends JpaRepository<Cupon, Long> {
    Cupon findById(long id);
}
