import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements Reajuste, ReajusteComImposto {
    private BigDecimal valor;
    private LocalDate data;

    public Promocao(BigDecimal valor, LocalDate data) {
        this.valor = valor;
        this.data = LocalDate.now();
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public LocalDate data() {
        return data;
    }

    @Override
    public BigDecimal valorImpostoDeRenda() {
        // Lógica para calcular o imposto de renda da promoção
        return BigDecimal.ZERO; // Exemplo: retorno zero para simplificar
    }
}