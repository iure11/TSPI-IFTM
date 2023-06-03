import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste extends ReajusteComImposto {
    BigDecimal valor();
    LocalDate data();
}
