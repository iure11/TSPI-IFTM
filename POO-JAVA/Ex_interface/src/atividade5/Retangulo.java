package atividade5;

public class Retangulo implements Relacao<Retangulo>{
    private int base;
    private int altura;

    public Retangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public int area() {
        return base * altura;
    }

    @Override
    public boolean igual(Retangulo outro) {
        return this.area() == outro.area();
    }

    @Override
    public boolean maior(Retangulo outro) {
        return this.area() > outro.area();
    }
}