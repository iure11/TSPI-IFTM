package atividade4;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Assistente(2000);
        Funcionario funcionario2 = new Gerente(3000);
        Funcionario funcionario3 = new Diretor(5000);

        System.out.println("Salário do assistente: " + funcionario1.calcularSalario());
        System.out.println("Salário do gerente: " + funcionario2.calcularSalario());
        System.out.println("Salário do diretor: " + funcionario3.calcularSalario());
    }
}