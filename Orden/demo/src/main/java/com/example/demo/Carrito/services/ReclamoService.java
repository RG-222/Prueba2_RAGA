package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Reclamo;
import com.example.demo.Carrito.repositories.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoService {

    @Autowired
    private ReclamoRepository repository;

    public List<Reclamo> findAll() { return repository.findAll(); }
    public Reclamo findById(Long id) { return repository.findById(id).orElse(null); }
    public Reclamo save(Reclamo obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
}