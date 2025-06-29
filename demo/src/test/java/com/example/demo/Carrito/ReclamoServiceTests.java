package com.example.demo.Carrito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Carrito.models.EstadoReclamo;
import com.example.demo.Carrito.models.Reclamo;
import com.example.demo.Carrito.services.ReclamoService;

@ActiveProfiles("test")
@SpringBootTest
public class ReclamoServiceTests {

    @Autowired
    private ReclamoService reclamoService;

    @Test
    void registraReclamoYQuedaPendiente() {
    Reclamo r = reclamoService.crearReclamo(1001L, "Producto llegó dañado");
    assertEquals(EstadoReclamo.PENDIENTE, r.getEstado());
}

}