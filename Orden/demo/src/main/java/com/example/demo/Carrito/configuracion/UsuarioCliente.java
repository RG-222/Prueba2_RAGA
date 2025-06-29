package com.example.demo.Carrito.configuracion;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UsuarioCliente {
    public String obtenerUsuario(Long id) {
        ResponseEntity<String> response = new RestTemplate()
            .getForEntity("http://localhost:8080/api/usuarios/" + id, String.class);
        return response.getBody();
    }
}
