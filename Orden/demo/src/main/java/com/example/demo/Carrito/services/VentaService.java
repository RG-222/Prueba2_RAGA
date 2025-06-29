package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Venta;
import com.example.demo.Carrito.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository repository;

    public List<Venta> findAll() { return repository.findAll(); }
    public Venta findById(Long id) { return repository.findById(id).orElse(null); }
    public Venta save(Venta obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
}
