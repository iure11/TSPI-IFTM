class DescontoPercentual extends Desconto {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcularDesconto(double preco) {
        return preco - (preco * percentual / 100.0);
    }
}