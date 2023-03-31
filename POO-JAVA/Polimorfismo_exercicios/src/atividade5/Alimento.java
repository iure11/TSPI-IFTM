package atividade5;

public class Alimento extends Produto {
    public Alimento(double preco) {
        super(preco);
    }

    @Override
    public double calcularDesconto() {
        return super.calcularDesconto() * 0.05;
    }
}
