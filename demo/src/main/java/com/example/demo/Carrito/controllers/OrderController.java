package com.example.demo.Carrito.controllers;

import com.example.demo.Carrito.models.Order;
import com.example.demo.Carrito.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
@Tag(name = "Órdenes", description = "Operaciones CRUD sobre órdenes")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping
    public List<Order> all() { return service.findAll(); }

    @GetMapping("/{id}")
public EntityModel<Order> one(@PathVariable Long id) {
    Order order = service.findById(id);
    if (order == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada");
    }
    EntityModel<Order> model = EntityModel.of(order);
    model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderController.class).one(id)).withSelfRel());
    model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderController.class).all()).withRel("all-orders"));
    return model;
}


    @PostMapping
    public Order save(@RequestBody Order obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
