package atividade3;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo1 = new Carro();
        Veiculo veiculo2 = new Moto();
        Veiculo veiculo3 = new Caminhao();

        veiculo1.acelerar(50);
        veiculo2.acelerar(60);
        veiculo3.acelerar(40);
    }
}