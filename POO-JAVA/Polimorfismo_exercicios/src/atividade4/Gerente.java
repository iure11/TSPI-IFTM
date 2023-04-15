package atividade5;

public class Gerente extends Funcionario {
    public Gerente(double salarioBase) {
        super(salarioBase);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (super.calcularSalario() * 0.2);
    }
}
