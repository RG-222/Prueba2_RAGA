package com.example.demo.Carrito.models;

import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "devoluciones")
public @Data class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ventaId;
    private String motivo;
    private String fecha;

}
