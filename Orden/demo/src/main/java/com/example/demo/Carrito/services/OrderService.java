<<<<<<< HEAD
package com.example.demo.Carrito.services;


import com.example.demo.Carrito.models.Order;
import com.example.demo.Carrito.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() { return repository.findAll(); }
    public Order findById(Long id) { return repository.findById(id).orElse(null); }
    public Order save(Order obj) { return repository.save(obj); }
    public void delete(Long id) { repository.deleteById(id); }
}
=======
package com.example.demo.Carrito.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.Carrito.models.Orden;
import com.example.demo.Carrito.models.ModificarOrden;
import com.example.demo.Carrito.repositories.OrdenRepository;

@Service
public class OrderService {
    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> obtenerTodos() {
        return ordenRepository.findAll();    
    }

    public Orden obtenerUno(int id){
        Orden orden = ordenRepository.findById(id);
        if (orden == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada");
        }
        return ordenRepository.findById(id);
    }

    public Orden agregar(Orden orden){
        orden.setFechaOrden(new Date());
        return ordenRepository.save(orden);
    }

    public void eliminar(int id){
        Orden orden = obtenerUno(id);
        ordenRepository.delete(orden);
    }

    public Orden modificar(int id, ModificarOrden body) {
        Orden orden = obtenerUno(id);
        if(body.getEstado() != null) {
            orden.setEstado(body.getEstado());
        }
        if(body.getFechaLlegada() != null) {
            orden.setFechaLlegada(body.getFechaLlegada());
        }
        return ordenRepository.save(orden);
    }
}
>>>>>>> a202460ac7941dc397187b5cc8bb604bd8ba6a39
