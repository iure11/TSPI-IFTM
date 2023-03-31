package atividade3;

public class Moto extends Veiculo {
    @Override
    public void acelerar(int velocidadeAtual) {
        System.out.println("Acelerando a moto a " + (velocidadeAtual + 30) + " km/h.");
    }
}