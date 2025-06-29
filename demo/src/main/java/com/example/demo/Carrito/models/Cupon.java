package com.example.demo.Carrito.models;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "cupon")
public @Data class Cupon {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String descuento;
    private String activo;

    @Column(name = "fecha_expiracion")
    private LocalDate fechaExpiracion;

}
