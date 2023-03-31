package atividade9;

class Quadrado extends Forma {
    double lado;

    Quadrado(double lado) {
        this.lado = lado;
    }

    double calcularArea() {
        return lado * lado;
    }
}
