package com.example.testedemo.service;

import com.example.testedemo.entidade.Conta;
import com.example.testedemo.repository.ContaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void deposito(Long id, Double valor) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.save(conta);
    }

    @Transactional
    public void saqueOtimista(Long id, Double valor) {
        try {
            Conta conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
            if (conta.getSaldo() >= valor) {
                conta.setSaldo(conta.getSaldo() - valor);
                contaRepository.save(conta);
            } else {
                throw new RuntimeException("Saldo insuficiente");
            }
        } catch (OptimisticLockException ole) {
            throw new RuntimeException("Conflito ao atualizar a conta. Tente novamente.");
        }
    }

    @Transactional
    public void saquePessimista(Long id, Double valor) {
        Conta conta = entityManager.find(Conta.class, id, LockModeType.PESSIMISTIC_WRITE);
        if (conta == null) {
            throw new RuntimeException("Conta não encontrada");
        }

        if (conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
            entityManager.merge(conta);
        } else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public Double getSaldo(Long id) {
        return contaRepository.findById(id)
                .map(Conta::getSaldo)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }
}
