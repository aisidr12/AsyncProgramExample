package com.prueba.demoyaml.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConstructorInjection {
    private final String name;


    public ConstructorInjection(@Qualifier("nombre") String name) {
        this.name = name;
    }
}
