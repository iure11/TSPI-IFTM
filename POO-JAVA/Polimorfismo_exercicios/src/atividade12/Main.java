package atividade12;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo1 = new Carro();
        Veiculo veiculo2 = new Moto();
        Garagem garagem = new Garagem();
        garagem.estacionar(veiculo1);
        garagem.estacionar(veiculo2);
    }
}
