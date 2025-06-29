package com.example.demo.Carrito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Carrito.models.Venta;
import com.example.demo.Carrito.repositories.VentaRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository repository;

    public List<Venta> findAll() { return repository.findAll(); }
    public Venta findById(Long id) { return repository.findById(id).orElse(null); }
    public Venta save(Venta obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
    public Venta setId(Venta obj) { return repository.save(obj); }
    
    public BigDecimal calcularTotal(List<LineaVenta> lineas) {
        BigDecimal subtotal = BigDecimal.ZERO;

        for (LineaVenta linea : lineas) {
            BigDecimal lineaTotal = linea.getPrecioUnitario()
                                         .multiply(BigDecimal.valueOf(linea.getCantidad()));
            subtotal = subtotal.add(lineaTotal);
        }

        BigDecimal iva = subtotal.multiply(new BigDecimal("0.19"));
        BigDecimal total = subtotal.add(iva);

        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
