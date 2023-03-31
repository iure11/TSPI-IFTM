package atividade10;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        Galinha galinha = new Galinha();

        Animal[] animais = {cachorro, gato, vaca, galinha};

        Fazenda fazenda = new Fazenda();
        fazenda.alimentarAnimais(animais);
    }
}
