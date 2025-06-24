package com.example.demo.Carrito.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Carrito.models.Producto;
import com.example.demo.Carrito.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Producto findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto save(Producto p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
