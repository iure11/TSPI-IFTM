package com.iftm.startexample.services;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final CircuitBreaker circuitBreaker;

    @Autowired
    public ConsumerService(CircuitBreakerRegistry circuitBreakerRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("consumer");
    }

    public String someMethod() {
        return circuitBreaker.executeSupplier(() -> {
            return "Deu Falha";
        });
    }
}
