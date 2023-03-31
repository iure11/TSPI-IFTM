package atividade5;

public class Vestuario extends Produto {
    public Vestuario(double preco) {
        super(preco);
    }

    @Override
    public double calcularDesconto() {
        return super.calcularDesconto() * 0.2;
    }
}