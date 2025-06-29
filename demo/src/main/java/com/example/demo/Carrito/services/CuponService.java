package com.example.demo.Carrito.services;

import com.example.demo.Carrito.models.Cupon;
import com.example.demo.Carrito.repositories.CuponRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CuponService {

    public CuponService(CuponRepository repository){
        this.repository = repository;
    }
    private CuponRepository repository;

    public List<Cupon> findAll() { return repository.findAll(); }
    public Cupon findById(Long Id) { return repository.findById(Id).orElse(null); }
    public Cupon save(Cupon obj) { return repository.save(obj); }
    public void delete(Long Id) { repository.deleteById(Id); }

    public Cupon crearCupon(String codigo, int descuento, LocalDate fechaExpiracion){
        Cupon cupon = new Cupon();
        cupon.setCodigo(codigo);
        cupon.setDescuento(String.valueOf(descuento));
        cupon.setActivo("true");
        cupon.setFechaExpiracion(fechaExpiracion);
        return repository.save(cupon);
    }

    public boolean esCuponValido(String codigo){
        Optional<Cupon> cuponOpt  = repository.findByCodigo(codigo);
        return cuponOpt
                .filter(c ->"true".equalsIgnoreCase(c.getActivo()))
                .filter(c ->!LocalDate.now().isAfter(c.getFechaExpiracion()))
                .isPresent();
    }
}
