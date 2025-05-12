package com.example.aula_12_05.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    public Double somar(Double a, Double b) {
        if (a == null || b == null){
            throw new IllegalArgumentException("Nao pode ser nulo");
        }
        return a + b;
    }
}
