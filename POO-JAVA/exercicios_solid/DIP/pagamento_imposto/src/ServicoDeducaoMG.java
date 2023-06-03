public class ServicoDeducaoMG implements ServicoDeducao {

    @Override
    public double deducao(double valor) {
        return valor * 0.12;
    }
}
