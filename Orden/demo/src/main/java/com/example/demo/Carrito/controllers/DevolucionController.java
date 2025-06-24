package com.example.demo.Carrito.controllers;

import com.example.demo.Carrito.models.Devolucion;
import com.example.demo.Carrito.services.DevolucionService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devolucion")
@Tag(name = "Devoluciones", description = "Operaciones CRUD sobre devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService service;

    @GetMapping
    public List<Devolucion> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Devolucion one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Devolucion save(@RequestBody Devolucion obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public Devolucion update(@PathVariable Long id, @RequestBody Devolucion obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}