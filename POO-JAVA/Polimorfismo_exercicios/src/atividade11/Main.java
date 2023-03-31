package atividade11;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(1000);
        ContaPoupanca contaPoupanca = new ContaPoupanca(5000, 1.5);

        Banco banco = new Banco();
        banco.adicionarConta(contaCorrente);
        banco.adicionarConta(contaPoupanca);

        System.out.println("Saldo antes do pagamento de juros:");
        System.out.println("Conta corrente: " + contaCorrente.getSaldo());
        System.out.println("Conta poupança: " + contaPoupanca.getSaldo());

        banco.pagaJuros();

        System.out.println("\nSaldo após o pagamento de juros:");
        System.out.println("Conta corrente: " + contaCorrente.getSaldo());
        System.out.println("Conta poupança: " + contaPoupanca.getSaldo());
    }
}
