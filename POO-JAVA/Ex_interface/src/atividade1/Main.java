package atividade1;

import java.util.ArrayList;
import java.util.List;
// Foram usados os seguintes conceitos, herença, polimorfismo e encapsulamento.
public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("João", "1234", 5000));
        funcionarios.add(new Assistente("Maria", "5678", 2500));
        funcionarios.add(new Vendedor("Pedro", "9012", 2000, 500));

        double folhaSalarial = 0;
        for (Funcionario f : funcionarios) {
            folhaSalarial += f.calculaSalario();
        }

        System.out.println("Folha salarial total: " + folhaSalarial);
    }
}