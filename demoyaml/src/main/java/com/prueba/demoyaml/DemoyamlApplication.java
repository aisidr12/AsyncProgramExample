package com.prueba.demoyaml;

import com.prueba.demoyaml.api.configuration.FieldInjection;
import com.prueba.demoyaml.api.configuration.SetterInjection;
import com.prueba.demoyaml.api.configuration.YamlConfiguration;
import com.prueba.demoyaml.controller.ConstructorInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoyamlApplication implements CommandLineRunner {

    @Autowired
    private YamlConfiguration myConfig;

    @Autowired
    private SetterInjection setterInjection;

    @Autowired
    private FieldInjection fieldInjection;


    @Autowired
    private ConstructorInjection constructorInjection;

    public static void main(String[] args) {
        SpringApplication.run(DemoyamlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicacion arrancada");

        System.out.println("environment:" + myConfig.getEnvironment());
        System.out.println("name: " + myConfig.getName());
        System.out.println("enabled:" + myConfig.isEnabled());
        System.out.println("servers: " + myConfig.getServers());


        System.out.println("Injectado por constructor " + constructorInjection.getName());

        System.out.println("Setter Injection " + setterInjection.nombreService());

        System.out.println("Recuperando por field Injection " + fieldInjection.retrivingByFieldInjection());


    }
}
