public class Main {
    public static void main(String[] args) {
        ServicoPagamento servicoPagamentoMG = new ServicoPagamento(new ServicoDeducaoMG());
        ServicoPagamento servicoPagamentoSP = new ServicoPagamento(new ServicoDeducaoSP());
        double impostoMG = servicoPagamentoMG.imposto(1000.00);
        double impostoSP = servicoPagamentoSP.imposto(1000.00);
        System.out.println("Imposto de MG: " + impostoMG);
        System.out.println("Imposto de SP: " + impostoSP);
    }
}
