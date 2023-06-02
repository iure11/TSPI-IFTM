class CalculadoraDesconto {
    public double aplicarDesconto(Produto produto, Desconto desconto) {
        double preco = produto.getPreco();
        return desconto.calcularDesconto(preco);
    }
}