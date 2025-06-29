package com.example.demo.Carrito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Carrito.models.Venta;
import com.example.demo.Carrito.repositories.VentaRepository;
import com.example.demo.Carrito.services.DevolucionService;

@ActiveProfiles("test")
@SpringBootTest
public class DevolucionServiceTests {

    @Autowired
    private DevolucionService devolucionService;

    @Autowired
    private VentaRepository ventaRepository;

    @Test
    public void testProcesarDevolucionYActualizarStock() {
        // Setup inicial: guardar una venta simulada
        Venta venta = new Venta();
        venta.setStock(0);  // stock inicial
        venta = ventaRepository.save(venta);

        Long ventaId = venta.getId();
        int unidadesDevueltas = 2;

        devolucionService.procesarDevolucion(ventaId, unidadesDevueltas);

        int stockActual = devolucionService.obtenerStockPorVenta(ventaId);
        assertEquals(2, stockActual, "El stock debería reflejar la devolución");
    }
}