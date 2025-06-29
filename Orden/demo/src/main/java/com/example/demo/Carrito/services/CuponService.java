package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Cupon;
import com.example.demo.Carrito.repositories.CuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuponService {

    @Autowired
    private CuponRepository repository;

    public List<Cupon> findAll() { return repository.findAll(); }
    public Cupon findById(Long id) { return repository.findById(id).orElse(null); }
    public Cupon save(Cupon obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
}
