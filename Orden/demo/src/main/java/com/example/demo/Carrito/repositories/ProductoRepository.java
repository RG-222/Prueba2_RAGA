package com.example.demo.Carrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Carrito.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findById(int Id);

}
