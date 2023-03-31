package atividade4;

public class Diretor extends Funcionario {
    public Diretor(double salarioBase) {
        super(salarioBase);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (super.calcularSalario() * 0.3);
    }
}
