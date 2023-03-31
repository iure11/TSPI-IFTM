package atividade11;

class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(double saldoInicial, double taxaJuros) {
        super(saldoInicial);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void calcularJuros() {
        this.saldo += this.saldo * (this.taxaJuros / 100);
    }
}