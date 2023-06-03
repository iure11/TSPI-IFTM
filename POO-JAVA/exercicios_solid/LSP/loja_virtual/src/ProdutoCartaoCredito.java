
class ProdutoCartaoCredito extends Produto {
    public ProdutoCartaoCredito(String descricao, double preco) {
        super(descricao, preco);
    }

    public String formaPagamento() {
        return "Cartão de crédito";
    }
}