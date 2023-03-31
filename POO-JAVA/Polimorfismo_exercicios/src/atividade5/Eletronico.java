package atividade5;

public class Eletronico extends Produto {
    public Eletronico(double preco) {
        super(preco);
    }

    @Override
    public double calcularDesconto() {
        return super.calcularDesconto() * 0.1;
    }
}
