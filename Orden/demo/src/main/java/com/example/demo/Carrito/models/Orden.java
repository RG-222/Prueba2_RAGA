package com.example.demo.Carrito.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordenes")
@AllArgsConstructor
@NoArgsConstructor
public @Data class Orden {
    
    @Id
    private int id;

    @NotBlank
    private String nombreCliente;
    
    @NotBlank
    private String rutCliente;

    @NotBlank
    private String perfume;
    
    @NotBlank
    private String marca;
  
    @Min(1)
    @Max(99999)
    private int precio;

    @Column(name = "fecha_orden", nullable = false)
    private Date fechaOrden;

    @Column(name = "fecha_llegada")
    private Date fechaLlegada;

    @NotBlank
    private String estado;
}
