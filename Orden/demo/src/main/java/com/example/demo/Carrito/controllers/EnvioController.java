package com.example.demo.Carrito.controllers;

import com.example.demo.Carrito.models.Envio;
import com.example.demo.Carrito.services.EnvioService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envio")
@Tag(name = "Envíos", description = "Operaciones CRUD sobre envíos")
public class EnvioController {

    @Autowired
    private EnvioService service;

    @GetMapping
    public List<Envio> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Envio one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Envio save(@RequestBody Envio obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public Envio update(@PathVariable Long id, @RequestBody Envio obj) {
        obj.setOrdenId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
