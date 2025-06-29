package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Producto;
import com.example.demo.Carrito.repositories.ProductoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> findAll() { return repository.findAll(); }
    public Producto findById(Long id) { return repository.findById(id).orElse(null); }
    public Producto save(Producto obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
    public Producto setId(Producto obj) { return repository.save(obj); }

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void descontarStock(Long productoId, int cantidad) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        int stockActual = producto.getStock();
        if (stockActual < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente");
        }

        producto.setStock(stockActual - cantidad);
        productoRepository.save(producto);
    }

    public int obtenerStock(Long productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return producto.getStock();
    }
}