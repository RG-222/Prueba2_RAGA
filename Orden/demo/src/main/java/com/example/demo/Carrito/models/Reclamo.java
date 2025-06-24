package com.example.demo.Carrito.models;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;

@Entity
public @Data class Reclamo {
    
    @Id
    private Long id;

    private String clienteId;
    private String mensaje;
    private String estado;

}
