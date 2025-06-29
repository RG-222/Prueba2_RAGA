package com.example.demo.models.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCreate {
 
    @NotBlank
    private String tipo_usuario;

    private String nombre;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String telefono;   
}
