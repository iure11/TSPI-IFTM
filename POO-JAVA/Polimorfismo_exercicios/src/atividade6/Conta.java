package atividade6;

public class Conta {
    protected int numero;
    protected double saldo;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void verificarConta() {
        System.out.println("Conta: " + this.numero);
        System.out.println("Saldo: R$" + this.saldo);
    }
}