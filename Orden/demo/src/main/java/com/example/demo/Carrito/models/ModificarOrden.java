package com.example.demo.Carrito.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import java.util.Date;

public @Data class ModificarOrden {
    
    @Min(1)
    @Max(99999)
    private int precio;
     
    private String estado;

    private Date fechaLlegada;
}
