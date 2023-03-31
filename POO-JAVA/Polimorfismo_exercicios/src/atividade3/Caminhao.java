package atividade3;

public class Caminhao extends Veiculo {
    @Override
    public void acelerar(int velocidadeAtual) {
        System.out.println("Acelerando o caminhão a " + (velocidadeAtual + 10) + " km/h.");
    }
}