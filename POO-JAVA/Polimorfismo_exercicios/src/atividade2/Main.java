package atividade2;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cachorro();
        Animal animal2 = new Gato();
        Animal animal3 = new Vaca();

        animal1.emitirSom();
        animal2.emitirSom();
        animal3.emitirSom();
    }
}