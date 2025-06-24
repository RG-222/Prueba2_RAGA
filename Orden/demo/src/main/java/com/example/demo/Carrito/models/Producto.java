package com.example.demo.Carrito.models;

import jakarta.persistence.Id;
import lombok.Data;

public @Data class Producto {
    @Id 
    private Long id;
    private String nombre;
    private int stock;
    private double precio;

}

