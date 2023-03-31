package atividade6;

public class ContaPoupanca extends Conta {
    private double juros;

    public ContaPoupanca(int numero, double saldo, double juros) {
        super(numero, saldo);
        this.juros = juros;
    }

    @Override
    public void verificarConta() {
        System.out.println("Conta Poupança: " + this.numero);
        System.out.println("Saldo: R$" + this.saldo);
        System.out.println("Juros: " + this.juros + "%");
    }
}