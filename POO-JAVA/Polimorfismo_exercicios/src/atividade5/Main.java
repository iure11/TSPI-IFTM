package atividade5;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Eletronico(1000);
        Produto produto2 = new Vestuario(500);
        Produto produto3 = new Alimento(50);

        System.out.println("Desconto do eletrônico: " + produto1.calcularDesconto());
        System.out.println("Desconto do vestuário: " + produto2.calcularDesconto());
        System.out.println("Desconto do alimento: " + produto3.calcularDesconto());
    }
}