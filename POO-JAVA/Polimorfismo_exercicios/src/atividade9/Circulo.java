package atividade9;

class Circulo extends Forma {
    double raio;

    Circulo(double raio) {
        this.raio = raio;
    }

    double calcularArea() {
        return Math.PI * raio * raio;
    }
}
