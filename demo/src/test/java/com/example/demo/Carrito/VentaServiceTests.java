package com.example.demo.Carrito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Carrito.services.LineaVenta;
import com.example.demo.Carrito.services.VentaService;

@ActiveProfiles("test")
@SpringBootTest
public class VentaServiceTests {

    @Autowired
    private VentaService ventaService;

    @Test
    void totalizaVentaConImpuestos() {
        BigDecimal total = ventaService.calcularTotal(
            List.of(new LineaVenta(1L, 2, new BigDecimal("5000")))
        );

        assertEquals(new BigDecimal("11900.00"), total,
                     "Debe sumar subtotales más IVA (19 %)");
    }
}