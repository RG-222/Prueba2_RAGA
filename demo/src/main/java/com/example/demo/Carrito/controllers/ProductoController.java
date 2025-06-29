package com.example.demo.Carrito.controllers;

import com.example.demo.Carrito.models.Producto;
import com.example.demo.Carrito.services.ProductoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos (stock)", description = "Operaciones CRUD sobre productos(stock)")
public class ProductoController {
        @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<Producto> one(@PathVariable Long id) {
        Producto p = service.findById(id);
        EntityModel<Producto> model = EntityModel.of(p);
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductoController.class).all()).withRel("todos"));
        return model;
    }

    @PostMapping
    public Producto save(@RequestBody Producto p) {
        return service.save(p);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto p) {
        p.setId(id);
        return service.save(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}