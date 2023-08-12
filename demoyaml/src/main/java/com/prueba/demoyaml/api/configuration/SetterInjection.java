package com.prueba.demoyaml.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterInjection {

    //SETTER INJECTION

    private NombreService nombreService;


    @Autowired
    public void injectar(NombreService nombreService) {
        this.nombreService = nombreService;
    }

    public NombreService getNombreService() {
        return nombreService;
    }

    public String nombreService() {
        return nombreService.nombreService();
    }
}
