package com.example.demo.Carrito.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Order {
    @Id
    private Long id;

    private String clienteId;
    private String productoId;
    private String cantidad;
    private String estado;

    public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getClienteId() {
    return clienteId;
}

public void setClienteId(String clienteId) {
    this.clienteId = clienteId;
}

public String getProductoId() {
    return productoId;
}

public void setProductoId(String productoId) {
    this.productoId = productoId;
}

public String getCantidad() {
    return cantidad;
}

public void setCantidad(String cantidad) {
    this.cantidad = cantidad;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}
}