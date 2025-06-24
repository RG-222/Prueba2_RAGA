package com.example.demo.Carrito.repositories;

import com.example.demo.Carrito.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(int Id);

}
