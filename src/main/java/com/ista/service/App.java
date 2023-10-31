package com.ista.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ista.service.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class App {
    public static void main (String[] args){
        SpringApplication.run(App.class, args);

        System.out.println("---------Ejecutando----------");
        
    }
}
