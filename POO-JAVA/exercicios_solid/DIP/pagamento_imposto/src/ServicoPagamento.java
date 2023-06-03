public class ServicoPagamento {
    private ServicoDeducao servicoDeducao;

    public ServicoPagamento(ServicoDeducao servicoDeducao) {
        this.servicoDeducao = servicoDeducao;
    }

    public double imposto(double valor){
        valor = valor - servicoDeducao.deducao(valor);
        return valor * 0.2;
    }
}
