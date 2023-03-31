package atividade9;

import java.util.List;

class CalculadoraDeAreas {
    double somarAreas(List<Forma> formas) {
        double total = 0;
        for (Forma forma : formas) {
            total += forma.calcularArea();
        }
        return total;
    }
}