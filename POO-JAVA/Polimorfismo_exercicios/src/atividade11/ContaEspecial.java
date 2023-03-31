package atividade11;

public class ContaEspecial extends Conta {
    private double limiteCredito;

    public ContaEspecial(double saldo, double limiteCredito) {
        super(saldo);
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}