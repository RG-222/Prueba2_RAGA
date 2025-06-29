package com.example.demo.Carrito.controllers;

import com.example.demo.Carrito.models.Cupon;
import com.example.demo.Carrito.services.CuponService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cupon")
@Tag(name = "Cupones", description = "Operaciones CRUD sobre cupones")
public class CuponController {
    
    @Autowired
    private CuponService service;

    @GetMapping
    public List<Cupon> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Cupon one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Cupon save(@RequestBody Cupon obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public Cupon update(@PathVariable Long id, @RequestBody Cupon obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}