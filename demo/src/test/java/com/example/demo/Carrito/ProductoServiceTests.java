package com.example.demo.Carrito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Carrito.models.Producto;
import com.example.demo.Carrito.repositories.ProductoRepository;
import com.example.demo.Carrito.services.ProductoService;

@ActiveProfiles("test")
@SpringBootTest
public class ProductoServiceTests {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    void descuentaStockAlVenderProducto() {
        // Creamos un producto con 10 unidades de stock
        Producto producto = new Producto();
        producto.setNombre("Producto Test");
        producto.setStock(10);
        producto.setPrecio(1000);
        producto = productoRepository.save(producto);

        Long productoId = producto.getId();
        productoService.descontarStock(productoId, 3);

        int stockRestante = productoService.obtenerStock(productoId);
        assertEquals(7, stockRestante, "El stock debería haberse reducido a 7 unidades");
    }
}