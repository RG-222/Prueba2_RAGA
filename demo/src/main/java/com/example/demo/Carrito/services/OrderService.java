package com.example.demo.Carrito.services;


import com.example.demo.Carrito.models.Order;
import com.example.demo.Carrito.models.Producto;
import com.example.demo.Carrito.repositories.OrderRepository;
import com.example.demo.Carrito.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private ProductoRepository productoRepository;

    public List<Order> findAll() { return orderRepository.findAll(); }
    public Order findById(Long id) { return orderRepository.findById(id).orElse(null); }
    public Order save(Order obj) { return orderRepository.save(obj); }
    public void delete(Long id) { orderRepository.deleteById(id); }

    public OrderService(OrderRepository orderRepository, ProductoRepository productoRepository) {
        this.orderRepository = orderRepository;
        this.productoRepository = productoRepository;
    }

    public Order crearPedidoPorIds(List<Long> productoIds) {
        List<Producto> productos = productoRepository.findAllById(productoIds);

        Order order = new Order();
        order.setProductos(productos);

        return orderRepository.save(order);
    }
}