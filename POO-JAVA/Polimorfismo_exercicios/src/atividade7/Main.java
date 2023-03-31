package atividade7;

public class Main {
    public static void main(String[] args) {
        Figura figura1 = new Circulo(5);
        Figura figura2 = new Retangulo(3, 4);
        Figura figura3 = new Triangulo(2, 5);

        System.out.println("Área do círculo: " + figura1.calcularArea());
        System.out.println("Área do retângulo: " + figura2.calcularArea());
        System.out.println("Área do triângulo: " + figura3.calcularArea());
    }
}
