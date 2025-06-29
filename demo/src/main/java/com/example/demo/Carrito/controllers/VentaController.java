package com.example.demo.Carrito.controllers;

import com.example.demo.Carrito.models.Venta;
import com.example.demo.Carrito.services.LineaVenta;
import com.example.demo.Carrito.services.VentaService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@Tag(name = "Ventas", description = "Operaciones CRUD sobre ventas")
public class VentaController {
    @Autowired
    private VentaService service;

    @GetMapping
    public List<Venta> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Venta one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Venta save(@RequestBody Venta obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public Venta update(@PathVariable Long id, @RequestBody Venta obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/calcular-total")
    public ResponseEntity<BigDecimal> calcularTotal(@RequestBody List<LineaVenta> lineas) {
        BigDecimal total = service.calcularTotal(lineas);
        return ResponseEntity.ok(total);
    }
}