package com.iftm.client.repositories;

import com.iftm.client.entities.Client;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository repositorio;




    /**
     * Cenário de Teste 1
     * Objetivo: Verificar se a busca por id realmente retorna o cliente correto.
     * ●
     * monta o cenário,
     * - arquivo import.sql carrega o cenário (clientes cadastrados)
     * - definir o id de um cliente que exista em import.sql
     * ●
     * executa a ação
     * - executar o método de buscar por id
     * (Utilizaremos a classe Optional para encapsular o objeto da
     * classe Client)
     * ●
     * e valida a saída.
     * - verifica se foi retornado um objeto.
     * - verifica se o nome e o cpf do cliente retornado corresponde
     * ao esperado.
     */
    @Test
    @DisplayName("Verificar se a busca por id realmente retorna o\n" + "     * cliente correto.")
    public void testarBuscaPorIDRetornaClienteCorreto() {
        long idBuscado = 1; //corresponde ao primeiro registro do arquivo import.sql
        String nomeBuscado = "Conceição Evaristo";
        String cpfBuscado = "10619244881";

        Client respostaEsperada = new Client(1L, "Conceição Evaristo", "10619244881", null, null, null);

        Optional<Client> resposta = repositorio.findById(idBuscado);

        //verificação se um client foi retornado
        Assertions.assertThat(resposta).isPresent();
        //assertTrue(resposta.isPresent());
        //assertNotNull(resposta.get());

        //verificar se o objeto retorna corresponde ao objeto esperado.
        //Assertions.assertThat(resposta.get()).isEqualTo(respostaEsperada);

        //verificar se os dados do cliente esperado corresponde aos dados do cliente retornado
        Assertions.assertThat(resposta.get().getName()).isEqualTo(nomeBuscado);
        Assertions.assertThat(resposta.get().getCpf()).isEqualTo(cpfBuscado);
        //assertEquals(nomeBuscado, resposta.get().getName());
        //assertEquals(cpfBuscado, resposta.get().getCpf());
    }

    /**
     * Cenário de Teste 2
     * Objetivo: Verificar se a busca por id inexistente retorna nenhum cliente.
     * ●
     * monta o cenário,
     * - arquivo import.sql carrega o cenário (clientes cadastrados)
     * - definir o id de um cliente que não exista em import.sql
     * ●
     * executa a ação
     * - executar o método de buscar por id
     * ●
     * e valida a saída.
     * - verifica se não foi retornado um objeto.
     */
    @Test
    @DisplayName("Verificar se a busca por id inexistente retorna nenhum cliente")
    public void testarBuscaPorIdNaoRetornaObjetoParaIdInexistente() {
        long idBuscado = 100;

        Optional<Client> resultado = repositorio.findById(idBuscado);

        Assertions.assertThat(resultado).isEmpty();
        //assertTrue(resultado.isEmpty());
    }

    /**
     * Cenário de Teste 3
     * Objetivo: Verificar se a exclusão realmente apaga um registro existente.
     * ●
     * monta o cenário,
     * - arquivo import.sql carrega o cenário (clientes cadastrados)
     * - definir o id de um cliente que exista em import.sql
     * ●
     * executa a ação
     * - executar o método de exclusão por id
     * - executar o método de buscar por id
     * ●
     * e valida a saída.
     * - verificar se o resultado do método de busca é falso
     */
    @Test
    @DisplayName("Verificar se a exclusão realmente apaga um registro existente.")
    public void TestarExcluirPorIdApagaRegistroExistente() {
        long idBuscado = 8;
        long quantidadeRegistrosEsperado = 11;

        repositorio.deleteById(idBuscado);
        Optional<Client> resultado = repositorio.findById(idBuscado);

        Assertions.assertThat(resultado).isEmpty();
        //assertTrue(resultado.isPresent());
        Assertions.assertThat(repositorio.count()).isEqualTo(quantidadeRegistrosEsperado);
        //assertEquals(quantidadeRegistrosEsperado, repositorio.count());

    }
    @Test
    @DisplayName("Verificar se a busca por nome existente retorna o cliente correto.")
    public void testarBuscaPorNomeExistenteRetornaClienteCorreto() {
        String nomeBuscado = "Conceição Evaristo";

        List<Client> resposta = repositorio.searchByName(nomeBuscado);

        Assertions.assertThat(resposta).isNotNull();
        Assertions.assertThat(resposta.size()).isEqualTo(1);
        Assertions.assertThat(resposta.get(0).getName()).isEqualTo(nomeBuscado);
    }

    @Test
    @DisplayName("Verificar se a busca por nome não existente não retorna nenhum cliente.")
    public void testarBuscaPorNomeNaoExistenteNaoRetornaClientes() {
        String nomeBuscado = "Fulano de Tal";

        List<Client> resposta = repositorio.searchByName(nomeBuscado);

        Assertions.assertThat(resposta).isEmpty();
    }
    @Test
    @DisplayName("Verificar busca de cliente com nome inexistente")
    public void testarBuscaPorNomeInexistente() {
        String nomeInexistente = "Nome que não existe";

        List<Client> resultado = repositorio.searchByName(nomeInexistente);

        Assertions.assertThat(resultado).isEmpty();
    }


    @Test
    public void testFindAllClientsWhenNameIsEmpty() {
        List<Client> clients = repositorio.searchByName("");
    }


    // teste de salarios
    @Test
    public void testBuscarClientesComSalarioMaiorQue() {
        List<Client> result = repositorio.buscarClientesComSalarioMaiorQue(2000.0);
        assertEquals(9, result.size());

    }

    @Test
    public void testBuscarClientesComSalarioMenorQue() {
        List<Client> result = repositorio.buscarClientesComSalarioMenorQue(1501.0);
        assertEquals(3, result.size());

    }

    @Test
    public void testBuscarClientesPorFaixaDeSalario() {
        List<Client> result = repositorio.buscarClientesPorFaixaDeSalario(1500.0, 2500.0);
        assertEquals(6, result.size());

    }


    // TESTE DATA
    @Test
    public void testFindClientsByBirthDateBetween() {
        Instant dataI = Instant.parse("1980-01-01T00:00:00Z");
        Instant dataT = Instant.now();

        List<Client> result = repositorio.findClientByBirthDateBetween(dataI, dataT);
        assertEquals(4, result.size());

    }

    @Test
    public void testUpdateClient() {
        // Criando um novo cliente
        Client newClient = new Client(1L, "João", "123.456.789-00", 2000.0, Instant.parse("1990-05-20T00:00:00Z"), 0);

        repositorio.save(newClient);

        // Atualizando o cliente com novo nome, salário e data de nascimento
        newClient.setName("João Silva");
        newClient.setIncome(2000.0);
        newClient.setBirthDate(Instant.parse("1990-01-01T00:00:00Z"));
        repositorio.save(newClient);

        // Verificando se as atualizações foram salvas corretamente
        Client clienteAtualizado = repositorio.findById(newClient.getId()).orElse(null);
        assertNotNull(clienteAtualizado);
        assertEquals("João Silva", clienteAtualizado.getName());
        assertEquals(2000.0, clienteAtualizado.getIncome(), 0.001);
        assertEquals(Instant.parse("1990-01-01T00:00:00Z"), clienteAtualizado.getBirthDate());

    }






}
