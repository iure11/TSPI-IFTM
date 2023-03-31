package atividade6;

public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta(123, 1000.00);
        ContaCorrente conta2 = new ContaCorrente(456, 5000.00, 2000.00);
        ContaPoupanca conta3 = new ContaPoupanca(789, 1500.00, 1.5);

        conta1.verificarConta();
        System.out.println();
        conta2.verificarConta();
        System.out.println();
        conta3.verificarConta();
    }
}
