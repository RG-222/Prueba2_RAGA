package com.example.demo.Carrito.repositories;

import com.example.demo.Carrito.models.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
    Reclamo findBy(long id);
}
