public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Camiseta", 50.0) {
        };
        Produto produto2 = new Produto("Calça", 100.0) {
        };

        Desconto descontoFixo = new DescontoFixo(10.0);
        Desconto descontoPercentual = new DescontoPercentual(20.0);

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        double novoPreco1 = calculadora.aplicarDesconto(produto1, descontoFixo);
        double novoPreco2 = calculadora.aplicarDesconto(produto2, descontoPercentual);

        System.out.println("Produto: " + produto1.getNome());
        System.out.println("Preço original: R$" + produto1.getPreco());
        System.out.println("Novo preço com desconto fixo: R$" + novoPreco1);
        System.out.println();

        System.out.println("Produto: " + produto2.getNome());
        System.out.println("Preço original: R$" + produto2.getPreco());
        System.out.println("Novo preço com desconto percentual: R$" + novoPreco2);
    }
}