package com.example.demo.Carrito;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.Carrito.services.CuponService;

@ActiveProfiles("test")
@SpringBootTest
class CuponServiceTests {

    @Autowired
    private CuponService cuponService;

    @Test
    void puedeAplicarCuponActivo() {
        String codigo = "DESC10";
        cuponService.crearCupon(codigo, 10, LocalDate.now().plusDays(5));

        boolean esValido = cuponService.esCuponValido(codigo);

        assertTrue(esValido, "El cupón debería ser válido mientras no expire");
    }
}
