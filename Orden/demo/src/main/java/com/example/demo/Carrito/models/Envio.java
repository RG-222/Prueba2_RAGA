package com.example.demo.Carrito.models;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Envio {

    @Id
    private Long id;
    
    private Long ordenId;
    private String direccionEnvio;
    private String estado;
}

