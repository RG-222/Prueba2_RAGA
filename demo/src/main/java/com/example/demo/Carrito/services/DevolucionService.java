package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Devolucion;
import com.example.demo.Carrito.models.Venta;
import com.example.demo.Carrito.repositories.DevolucionRepository;
import com.example.demo.Carrito.repositories.VentaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository repository;

    public List<Devolucion> findAll() { return repository.findAll(); }
    public Devolucion findById(Long id) { return repository.findById(id).orElse(null); }
    public Devolucion save(Devolucion obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
    public Devolucion setId(Devolucion obj) { return repository.save(obj); }

    private final VentaRepository ventaRepository;

    public DevolucionService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public void procesarDevolucion(Long ventaId, int unidadesDevueltas) {
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        int nuevoStock = venta.getStock() + unidadesDevueltas;
        venta.setStock(nuevoStock);
        ventaRepository.save(venta);
    }

    public int obtenerStockPorVenta(Long ventaId) {
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        return venta.getStock();
    }
}

