package com.example.demo.Carrito.services;


import com.example.demo.Carrito.models.Order;
import com.example.demo.Carrito.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() { return repository.findAll(); }
    public Order findById(Long id) { return repository.findById(id).orElse(null); }
    public Order save(Order obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
}