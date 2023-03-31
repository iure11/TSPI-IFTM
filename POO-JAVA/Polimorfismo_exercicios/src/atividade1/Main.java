package atividade1;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Aluno("João", "Engenharia");
        Pessoa pessoa2 = new Professor("Maria", "Matemática");
        Pessoa pessoa3 = new Funcionario("José", "Secretário");

        pessoa1.apresentar();
        pessoa2.apresentar();
        pessoa3.apresentar();
    }
}