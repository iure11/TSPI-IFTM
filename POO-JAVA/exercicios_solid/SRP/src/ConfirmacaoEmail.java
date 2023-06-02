public class ConfirmacaoEmail {
    private Pagamento pagamento;

    public ConfirmacaoEmail(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void enviarEmailConfirmacao() {
        if (pagamento.isPago()) {

            System.out.println("Email de confirmação enviado");
        }
    }
}