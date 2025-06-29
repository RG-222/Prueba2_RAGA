package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Envio;
import com.example.demo.Carrito.repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository repository;

    public List<Envio> findAll() { return repository.findAll(); }
    public Envio findById(Long id) { return repository.findById(id).orElse(null); }
    public Envio save(Envio obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
    public Envio setId(Envio obj) { return repository.save(obj); }
    
    public BigDecimal calcularCostoEnvio(String region, double pesoKg) {
        BigDecimal costoPorKg;

        switch (region.toUpperCase()) {
            case "RM":
                costoPorKg = new BigDecimal("1140");  // Región Metropolitana
                break;
            case "V":
                costoPorKg = new BigDecimal("1500");
                break;
            default:
                costoPorKg = new BigDecimal("2000");  // Resto del país
                break;
        }

        BigDecimal peso = BigDecimal.valueOf(pesoKg);
        BigDecimal costo = costoPorKg.multiply(peso).setScale(2, RoundingMode.HALF_UP);

        return costo;
    }
}