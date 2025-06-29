package com.example.demo.Carrito.repositories;

import com.example.demo.Carrito.models.Cupon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponRepository extends JpaRepository<Cupon, Long> {
    Cupon findById(long id);
    Optional<Cupon>  findByCodigo(String codigo);
}
