package atividade5;

public class Main2 {
    public static void main(String[] args) {
        Retangulo ret1 = new Retangulo(5, 10);
        Retangulo ret2 = new Retangulo(10, 5);

        if (ret1.igual(ret2)) {
            System.out.println("Os retângulos têm a mesma área");
        } else {
            System.out.println("Os retângulos têm áreas diferentes");
        }
    }
}
