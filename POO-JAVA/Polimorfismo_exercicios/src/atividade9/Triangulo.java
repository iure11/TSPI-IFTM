package atividade9;

class Triangulo extends Forma {
    double base, altura;

    Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    double calcularArea() {
        return (base * altura) / 2;
    }
}