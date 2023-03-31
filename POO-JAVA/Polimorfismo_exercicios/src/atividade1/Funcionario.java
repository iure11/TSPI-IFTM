package atividade1;

public class Funcionario extends Pessoa {
    private String funcao;

    public Funcionario(String nome, String funcao) {
        super(nome);
        this.funcao = funcao;
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, eu sou " + nome + " e minha função é " + funcao + ".");
    }
}
