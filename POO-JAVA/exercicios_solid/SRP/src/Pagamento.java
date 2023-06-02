public class Pagamento {
    private CarrinhoCompras carrinho;
    private boolean pago;

    public Pagamento(CarrinhoCompras carrinho) {
        this.carrinho = carrinho;
        this.pago = false;
    }

    public void processaPagamento() {
        // Lógica para processar o pagamento

        // Exemplo simples: definindo o atributo pago como true
        pago = true;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}