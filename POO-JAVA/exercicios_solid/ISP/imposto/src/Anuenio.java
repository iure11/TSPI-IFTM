import java.math.BigDecimal;
import java.time.LocalDate;

public class Anuenio implements Reajuste {
    private BigDecimal valor;
    private LocalDate data;

    public Anuenio(BigDecimal valor, LocalDate data) {
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
        throw new UnsupportedOperationException("O reajuste salarial anual é isento de imposto de renda.");
    }
}