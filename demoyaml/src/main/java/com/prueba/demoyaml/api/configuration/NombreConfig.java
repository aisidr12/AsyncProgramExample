package com.prueba.demoyaml.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NombreConfig {

    private String name = "Arturo";

    @Bean("nombre")
    public String nombreEntorno() {
        return this.name;
    }
}
