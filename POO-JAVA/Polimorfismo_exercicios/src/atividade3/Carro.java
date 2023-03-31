package atividade3;

public class Carro extends Veiculo {
    @Override
    public void acelerar(int velocidadeAtual) {
        System.out.println("Acelerando o carro a " + (velocidadeAtual + 20) + " km/h.");
    }
}