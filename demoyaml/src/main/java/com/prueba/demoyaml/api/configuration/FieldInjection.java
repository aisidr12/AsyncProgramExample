package com.prueba.demoyaml.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldInjection {

    @Autowired
    public NombreService nombreService;


    public String retrivingByFieldInjection() {
        return nombreService.nombreService();
    }


}
