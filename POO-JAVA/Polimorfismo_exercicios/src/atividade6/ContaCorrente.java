package atividade6;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numero, double saldo, double limite) {
        super(numero, saldo);
        this.limite = limite;
    }

    @Override
    public void verificarConta() {
        System.out.println("Conta Corrente: " + this.numero);
        System.out.println("Saldo: R$" + this.saldo);
        System.out.println("Limite: R$" + this.limite);
    }
}
