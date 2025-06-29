package com.example.demo.Carrito.models;

import jakarta.persistence.Id;
import lombok.Data;

public @Data class Devolucion {

    @Id
    private Long id;

    private String ventaId;
    private String motivo;
    private String fecha;

}
