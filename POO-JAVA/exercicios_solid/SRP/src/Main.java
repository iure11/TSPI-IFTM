public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Produto produto1 = new Produto("Camiseta", 29.99);
        Produto produto2 = new Produto("Calça", 59.99);
        Produto produto3 = new Produto("Tênis", 99.99);

        // Criando o carrinho de compras
        CarrinhoCompras carrinho = new CarrinhoCompras();

        // Adicionando produtos ao carrinho
        carrinho.addItem(produto1, 2);
        carrinho.addItem(produto2, 1);
        carrinho.addItem(produto3, 3);

        // Calculando o preço total do carrinho
        double precoTotal = carrinho.calcularPrecoTotal();
        System.out.println("Preço total do carrinho: " + precoTotal);

        // Criando o pagamento com o carrinho de compras
        Pagamento pagamento = new Pagamento(carrinho);

        // Processando o pagamento
        pagamento.processaPagamento();

        // Enviando o email de confirmação
        ConfirmacaoEmail confirmacaoEmail = new ConfirmacaoEmail(pagamento);
        confirmacaoEmail.enviarEmailConfirmacao();
    }
}
