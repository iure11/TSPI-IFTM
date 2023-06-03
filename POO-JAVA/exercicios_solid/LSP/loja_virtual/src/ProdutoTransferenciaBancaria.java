class ProdutoTransferenciaBancaria extends Produto {
    public ProdutoTransferenciaBancaria(String descricao, double preco) {
        super(descricao, preco);
    }

    public String formaPagamento() {
        return "Transferência bancária";
    }
}