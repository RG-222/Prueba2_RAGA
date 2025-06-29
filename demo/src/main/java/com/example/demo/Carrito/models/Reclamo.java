package com.example.demo.Carrito.models;

import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "reclamos")
public @Data class Reclamo {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version; // Hibernate lo necesita si activas versionado

    private Long ventaId;

    private String detalle;

    @Enumerated(EnumType.STRING)
    private EstadoReclamo estado;

}
