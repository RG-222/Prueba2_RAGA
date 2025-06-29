package com.example.demo.models;


import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String tipo_usuario;

    private String nombre;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String telefono;

    @Column(name="fecha_creacion")
    private Date fechaCreacion;

    private Boolean activo;
        
}
