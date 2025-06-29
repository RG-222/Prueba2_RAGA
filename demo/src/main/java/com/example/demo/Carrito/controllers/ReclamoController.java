package com.example.demo.Carrito.controllers;

import com.example.demo.Carrito.models.Reclamo;
import com.example.demo.Carrito.services.ReclamoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamo")
@Tag(name = "Reclamos", description = "Operaciones CRUD sobre reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService service;

    @GetMapping
    public List<Reclamo> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Reclamo one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Reclamo save(@RequestBody Reclamo obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public Reclamo update(@PathVariable Long id, @RequestBody Reclamo obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
