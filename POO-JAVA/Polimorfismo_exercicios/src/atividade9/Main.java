package atividade9;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();

        formas.add(new Triangulo(5, 10));
        formas.add(new Triangulo(7, 8));
        formas.add(new Circulo(2));
        formas.add(new Circulo(5));
        formas.add(new Quadrado(4));

        CalculadoraDeAreas calculadora = new CalculadoraDeAreas();
        double totalAreas = calculadora.somarAreas(formas);
        System.out.println("A soma das áreas é: " + totalAreas);
    }
}
