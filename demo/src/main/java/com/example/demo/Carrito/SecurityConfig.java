package com.example.demo.Carrito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // desactiva protección CSRF para facilitar pruebas
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // permite todo tipo de peticiones sin autenticación
            );
        return http.build();
    }
}
