package atividade4;

public class Main {
    public static void main(String[] args) {
        Linha linha1 = new Linha(0, 0, 3, 4);
        Linha linha2 = new Linha(0, 0, 6, 8);

        System.out.println("Linha 1: " + linha1.getTamanho());
        System.out.println("Linha 2: " + linha2.getTamanho());

        System.out.println("Linha 1 é maior que Linha 2? " + linha1.eMaior(linha1, linha2));
        System.out.println("Linha 1 é menor que Linha 2? " + linha1.eMenor(linha1, linha2));
        System.out.println("Linha 1 é igual a Linha 2? " + linha1.eIgual(linha1, linha2));
    }
}