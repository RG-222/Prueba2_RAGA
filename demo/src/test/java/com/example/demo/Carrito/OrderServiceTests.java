package com.example.demo.Carrito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Carrito.models.Order;
import com.example.demo.Carrito.models.Producto;
import com.example.demo.Carrito.repositories.ProductoRepository;
import com.example.demo.Carrito.services.OrderService;

@ActiveProfiles("test")
@SpringBootTest
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void creaPedidoConDosProductos() {
        Producto p1 = new Producto();
        p1.setNombre("Producto A");
        p1.setStock(10);
        p1.setPrecio(1500);
        p1 = productoRepository.save(p1);

        Producto p2 = new Producto();
        p2.setNombre("Producto B");
        p2.setStock(20);
        p2.setPrecio(2000);
        p2 = productoRepository.save(p2);

        // Crear pedido con esos productos
        Order order = orderService.crearPedidoPorIds(List.of(p1.getId(), p2.getId()));

        assertNotNull(order.getId(), "El pedido debería persistirse y tener ID");
        assertEquals(2, order.getProductos().size(), "El pedido debe contener dos productos");
    }
}