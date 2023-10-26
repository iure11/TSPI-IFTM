package com.example.testedemo.controller;

import com.example.testedemo.entidade.Conta;
import com.example.testedemo.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/deposito")
    public ResponseEntity<Void> deposito(@RequestParam Long id, @RequestParam Double valor) {
        contaService.deposito(id, valor);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saque/otimista")
    public ResponseEntity<Void> saqueOtimista(@RequestParam Long id, @RequestParam Double valor) {
        contaService.saqueOtimista(id, valor);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saque/pessimista")
    public ResponseEntity<Void> saquePessimista(@RequestParam Long id, @RequestParam Double valor) {
        contaService.saquePessimista(id, valor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<Double> getSaldo(@PathVariable Long id) {
        Double saldo = contaService.getSaldo(id);
        return ResponseEntity.ok(saldo);
    }
}


