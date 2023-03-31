package atividade11;

import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void pagaJuros() {
        for (Conta conta : contas) {
            if (conta instanceof ContaPoupanca) {
                ((ContaPoupanca) conta).calcularJuros();
            }
        }
    }
}

