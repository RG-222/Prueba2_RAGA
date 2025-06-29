package com.example.demo.Carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Carrito.models.ModificarOrden;
import com.example.demo.Carrito.models.Orden;
import com.example.demo.Carrito.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("ordenes")
public class OrdenController {
        
    @Autowired
    private OrderService sOrden;

    @GetMapping("")
    public List<Orden> todos(){
        return sOrden.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Orden obtenerUno(@PathVariable int id){
        System.out.println(">>>>Id buscando:"+id);
        return sOrden.obtenerUno(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id){
        sOrden.eliminar(id);
        return "Eliminado!";
    }

    @PostMapping("")
    public String agregar(@Valid @RequestBody Orden orden){
        sOrden.agregar(orden);
        return "Agregado!";
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody ModificarOrden orden) {
        sOrden.modificar(id, orden);
        return "Modificado!";
    }
}
