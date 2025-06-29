package com.example.demo.Carrito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Carrito.services.EnvioService;

@ActiveProfiles("test")
@SpringBootTest
class EnvioServiceTests {

    @Autowired
    private EnvioService envioService;

    @Test
    void calculaCostoEnvioPorRegion() {
        BigDecimal costo = envioService.calcularCostoEnvio("RM", 3.5); // Región Metropolitana, 3.5 kg

        assertEquals(new BigDecimal("3990.00"), costo,
                     "El costo de envío para 3.5 kg en la RM debería ser 3 990 CLP");
    }
}
