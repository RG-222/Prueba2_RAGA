package com.example.demo.Carrito.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient userWebClient() {
        return WebClient.builder()
            .build();
    }
}
