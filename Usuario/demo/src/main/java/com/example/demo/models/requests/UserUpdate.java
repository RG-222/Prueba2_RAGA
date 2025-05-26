package com.example.demo.models.requests;

import lombok.Data;

@Data
public class UserUpdate {
    private int id;

    private String tipo_usuario;
    private String nombre;
    private String telefono;
    private String password;
}
