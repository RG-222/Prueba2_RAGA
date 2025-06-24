package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Envio;
import com.example.demo.Carrito.repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository repository;

    public List<Envio> findAll() { return repository.findAll(); }
    public Envio findById(Long id) { return repository.findById(id).orElse(null); }
    public Envio save(Envio obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
    public Envio setId(Envio obj) { return repository.save(obj); }

}
