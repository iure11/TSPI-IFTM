package atividade3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria um retângulo com base 3 e altura 4
        FormaGeometrica retangulo = new Retangulo(3, 4);

        // Cria um círculo com raio 5
        FormaGeometrica circulo = new Circulo(5);

        // Armazena os objetos em uma lista
        List<FormaGeometrica> formas = new ArrayList<>();
        formas.add(retangulo);
        formas.add(circulo);

        // Imprime os perímetros e as áreas de todas as formas
        for (FormaGeometrica forma : formas) {
            System.out.printf("Área: %.2f - Perímetro: %.2f%n", forma.calcularArea(), forma.calcularPerimetro());
        }
    }
}