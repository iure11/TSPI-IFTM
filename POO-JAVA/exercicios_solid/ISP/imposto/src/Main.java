import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Criando um objeto Anuenio
        BigDecimal valorAnuenio = new BigDecimal("1000");
        LocalDate dataAnuenio = LocalDate.of(2023, 5, 15);
        Anuenio anuenio = new Anuenio(valorAnuenio, dataAnuenio);

        // Criando um objeto Promocao
        BigDecimal valorPromocao = new BigDecimal("500");
        LocalDate dataPromocao = LocalDate.of(2023, 6, 1);
        Promocao promocao = new Promocao(valorPromocao, dataPromocao);

        // Obtendo os valores e datas dos reajustes
        BigDecimal valorReajusteAnuenio = anuenio.valor();
        LocalDate dataReajusteAnuenio = anuenio.data();
        BigDecimal valorReajustePromocao = promocao.valor();
        LocalDate dataReajustePromocao = promocao.data();

        // Exibindo os valores e datas dos reajustes
        System.out.println("Reajuste Anuenio:");
        System.out.println("Valor: " + valorReajusteAnuenio);
        System.out.println("Data: " + dataReajusteAnuenio);

        System.out.println();

        System.out.println("Reajuste Promocao:");
        System.out.println("Valor: " + valorReajustePromocao);
        System.out.println("Data: " + dataReajustePromocao);

        // Calculando o imposto de renda apenas para o reajuste de promoção
        BigDecimal impostoPromocao = promocao.valorImpostoDeRenda();
        System.out.println("Imposto de Renda da Promocao: " + impostoPromocao);
    }
}
