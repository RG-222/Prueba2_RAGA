package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Devolucion;
import com.example.demo.Carrito.repositories.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository repository;

    public List<Devolucion> findAll() { return repository.findAll(); }
    public Devolucion findById(Long id) { return repository.findById(id).orElse(null); }
    public Devolucion save(Devolucion obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
}

