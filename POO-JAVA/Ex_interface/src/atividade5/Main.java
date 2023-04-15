package atividade5;

public class Main {
    public static void main(String[] args) {
        Retangulo ret1 = new Retangulo(5, 10);
        Retangulo ret2 = new Retangulo(8, 12);

        if (ret1.maior(ret2)) {
            System.out.println("O retângulo com maior área tem base " + ret1.getBase() + " e altura " + ret1.getAltura());
        } else {
            System.out.println("O retângulo com maior área tem base " + ret2.getBase() + " e altura " + ret2.getAltura());
        }


    }
}