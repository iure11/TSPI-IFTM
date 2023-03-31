package atividade4;

public class Assistente extends Funcionario {
    public Assistente(double salarioBase) {
        super(salarioBase);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (super.calcularSalario() * 0.1);
    }
}
