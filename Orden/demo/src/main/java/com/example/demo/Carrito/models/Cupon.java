package com.example.demo.Carrito.models;

import jakarta.persistence.Id;
import lombok.Data;

public @Data class Cupon {
        
    @Id
    private Long id;

    private String codigo;
    private String descuento;
    private String activo;

}
