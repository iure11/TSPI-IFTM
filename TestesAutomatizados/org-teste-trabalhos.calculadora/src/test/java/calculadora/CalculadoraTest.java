package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
	private Calculadora calc;
	
	
	@Test
	@DisplayName("teste para o construtor sem parâmetro de entrada.")
	public void testarConstrutorSemParametroIniciaMemoriaComZero() {
		//definir cenário
		int resultadoEsperado = 0;
		
		//executar
		calc = new Calculadora();
		int resultadoObtido = calc.getMemoria();
		
		//comparar
		assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	@DisplayName("Teste om algum valor no parametro Positivo ")
	public void testeContrudorComParametroPositivo() {
		calc = new Calculadora();
		int valorInicial = 3;
		Calculadora calc = new Calculadora(2);

		assertEquals(valorInicial, calc.getMemoria(), "O valor da memória deveria ser igual ao valor inicial.");

	}
	@Test
	public void testeContrudorComParametro() {
		calc = new Calculadora(3);
		int resultadoEsperado = 3;
		int resultadoObtido = calc.getMemoria();

		assertEquals(resultadoEsperado, resultadoObtido);

	}

	@DisplayName("somar um número negativo.")
	@Test
	public void testeConstrudorSomar() {
		calc = new Calculadora(3);
		calc.somar(-5);
		int resultadoEsperado = -2;
		int resultadoObtido = calc.getMemoria();

		assertEquals(resultadoEsperado,resultadoObtido);
	}

	@DisplayName("Somar um número positivo")
	@Test
	public void testeConstrudorSubtrair() {
		calc = new Calculadora(3);
		calc.subtrair(-5);
		int resultadoEsperado = 3;
		int resultadoObtido = calc.getMemoria();

		assertEquals(resultadoEsperado,resultadoObtido);
	}

	@DisplayName("Multiplicar com número positivo")
	@Test
	public void testeConstrudorMultiplicar() {
		calc = new Calculadora(3);
		calc.multiplicar(-5);
		int resultadoEsperado = 0;
		int resultadoObtido = calc.getMemoria();

		assertEquals(resultadoEsperado,resultadoObtido);
	}

	@Test
	@DisplayName("Teste dividir por valor positivo")
	public void testDividirPorValorPositivo() throws Exception {
		Calculadora calc = new Calculadora(3);
		calc.dividir(2);
		assertEquals(2, calc.getMemoria());
	}


	@DisplayName("Teste Dividir por Zero")
	@Test
	public void testDividirPorZero() throws Exception {
		Calculadora calculadora = new Calculadora(3);
		Exception exception = assertThrows(Exception.class, () -> calc.dividir(0));
		//assertNull(exception.getMessage());
	}


	@DisplayName("Exponeciar memoria por 1")
	@Test
	public void testExponenciarMemoriaPor1() throws Exception {
		Calculadora calc = new Calculadora(3);
		calc.exponenciar(1);
		assertEquals(9, calc.getMemoria());
	}

	@DisplayName("Exponeciar memoria por 10")
	@Test
	public void testExponenciarMemoriaPor10() throws Exception {
		Calculadora calc = new Calculadora(3);
		calc.exponenciar(10);
		assertEquals(59049, calc.getMemoria());
	}

	@DisplayName("Exponeciar memoria por >10")
	@Test
	public void testExponenciarMemoriaPorValorMaiorQue10() throws Exception {
		Calculadora calc = new Calculadora(3);
		Exception exception = assertThrows(Exception.class, () -> {
			calc.exponenciar(11);
		});
		assertEquals(0, exception.getMessage());
	}

	@DisplayName("Testar memoria por zero")
	@Test
	public void testZerasrMemoria() {
		Calculadora calc = new Calculadora(3);
		calc.zerarMemoria();
		assertEquals(0, calc.getMemoria());
	}











}





