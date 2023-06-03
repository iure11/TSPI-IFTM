public class Main {
    public static void main(String[] args) {
        ProdutoCartaoCredito produto1 = new ProdutoCartaoCredito("Produto 1", 10.99);
        ProdutoBoletoBancario produto2 = new ProdutoBoletoBancario("Produto 2", 19.99);
        ProdutoTransferenciaBancaria produto3 = new ProdutoTransferenciaBancaria("Produto 3", 29.99);

        Produto[] produtos = {produto1, produto2, produto3};

        for (Produto produto : produtos) {
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Forma de pagamento: " + obterFormaPagamento(produto));
            System.out.println();
        }
    }

    public static String obterFormaPagamento(Produto produto) {
        if (produto instanceof ProdutoCartaoCredito) {
            return ((ProdutoCartaoCredito) produto).formaPagamento();
        } else if (produto instanceof ProdutoBoletoBancario) {
            return ((ProdutoBoletoBancario) produto).formaPagamento();
        } else if (produto instanceof ProdutoTransferenciaBancaria) {
            return ((ProdutoTransferenciaBancaria) produto).formaPagamento();
        } else {
            return "Forma de pagamento não especificada";
        }
    }
}