package atividade1;

public class Professor extends Pessoa {
    private String areaFormacao;

    public Professor(String nome, String areaFormacao) {
        super(nome);
        this.areaFormacao = areaFormacao;
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, eu sou " + nome + " e minha área de formação é " + areaFormacao + ".");
    }
}
