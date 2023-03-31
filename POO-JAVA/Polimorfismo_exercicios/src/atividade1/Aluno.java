package atividade1;

public class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, String curso) {
        super(nome);
        this.curso = curso;
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, eu sou " + nome + " e estou matriculado no curso de " + curso + ".");
    }
}