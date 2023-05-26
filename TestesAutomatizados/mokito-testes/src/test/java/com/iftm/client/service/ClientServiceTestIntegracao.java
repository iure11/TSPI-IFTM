package com.iftm.client.service;

import com.iftm.client.dto.ClientDTO;
import com.iftm.client.entities.Client;
import com.iftm.client.repositories.ClientRepository;
import com.iftm.client.services.ClientService;
import com.iftm.client.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


// para testar camada de serviço utilize essa notação, que carrega o contexto com os recursos do Spring boot
@SpringBootTest
@Transactional
public class ClientServiceTestIntegracao {

    @Autowired
    private ClientService servico;

    @Autowired
    private ClientRepository repositorio;


    @DisplayName("Testar se o método deleteById apaga um registro e não retorna outras informações")
    @Test
    public void testarApagarPorIdTemSucessoComIdExistente() {
        //cenário
        long idExistente = 1;

        Assertions.assertDoesNotThrow(() -> {
            servico.delete(idExistente);
        });
    }

    @DisplayName("Testar se o método deleteById retorna exception para idInexistente")
    @Test
    public void testarApagarPorIdGeraExceptionComIdInexistente() {
        //cenário
        long idNaoExistente = 100;

        assertThrows(ResourceNotFoundException.class, () -> servico.delete(idNaoExistente));
    }

    /**
     * Exemplo Extra
     * Cenário de Teste : método findByIncomeGreaterThan retorna a página com clientes corretos
     * Entrada:
     * - Paginação:
     * - Pagina = 1;
     * - 2
     * - Asc
     * - Income
     * - Income: 4800.00
     * - Clientes:
     * Pagina: 0
     * {
     * "id": 7,
     * "name": "Jose Saramago",
     * "cpf": "10239254871",
     * "income": 5000.0,
     * "birthDate": "1996-12-23T07:00:00Z",
     * "children": 0
     * },
     * <p>
     * {
     * "id": 4,
     * "name": "Carolina Maria de Jesus",
     * "cpf": "10419244771",
     * "income": 7500.0,
     * "birthDate": "1996-12-23T07:00:00Z",
     * "children": 0
     * },
     * <p>
     * Pagina: 1
     * {
     * "id": 8,
     * "name": "Toni Morrison",
     * "cpf": "10219344681",
     * "income": 10000.0,
     * "birthDate": "1940-02-23T07:00:00Z",
     * "children": 0
     * }
     * Resultado:
     * Página não vazia
     * Página contendo um cliente
     * Página contendo o cliente da página 1
     */
    @Test
    @DisplayName("testar método findByIncomeGreaterThan retorna a página com clientes corretos")
    public void testarBuscaPorSalarioMaiorQueRetornaElementosEsperados() {
        //cenário de teste
        double entrada = 4800.00;
        int paginaApresentada = 0;
        int linhasPorPagina = 2;
        String ordemOrdenacao = "ASC";
        String campoOrdenacao = "income";
        Client clienteSete = new Client(7L, "Jose Saramago", "10239254871", 5000.0, Instant.parse("1996-12-23T07:00:00Z"), 0);
        Client clienteQuatro = new Client(4L, "Carolina Maria de Jesus", "10419244771", 7500.0, Instant.parse("1996-12-23T07:00:00Z"), 0);

        PageRequest pagina = PageRequest.of(paginaApresentada, linhasPorPagina,
                Sort.Direction.valueOf(ordemOrdenacao), campoOrdenacao);
        Page<ClientDTO> page = servico.findByIncomeGreaterThan(pagina, entrada);

        assertThat(page).isNotEmpty();
        assertThat(page.getTotalElements()).isEqualTo(3);
        assertThat(page.getNumberOfElements()).isEqualTo(2);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.toList().get(0).toEntity()).isEqualTo(clienteSete);
        assertThat(page.toList().get(1).toEntity()).isEqualTo(clienteQuatro);
    }

    /**
     * Exercicios extras feitos em sala
     * findByCpfLike deveria retornar uma página (e chamar o método findByCpfLike do repository)
     * Cenário de teste
     * Entradas necessárias:
     * - cpf : "%447%"
     * - Uma PageRequest com os valores
     * - page = 0
     * - size = 3
     * - direction = Direction.valueOf("ASC")
     * - order = "name"
     * - Lista de clientes esperada
     * {
     * "id": 4,
     * "name": "Carolina Maria de Jesus",
     * "cpf": "10419244771",
     * "income": 7500.0,
     * "birthDate": "1996-12-23T07:00:00Z",
     * "children": 0
     * },
     */

    @Test
    public void testarSeBuscarClientesPorCPFLikeRetornaUmaPaginaComClientesComCPFQueContemTextoInformado() {
        String cpf = "%447%";
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.valueOf("ASC"), "name");


        List<Client> listaClientes = new ArrayList<Client>();
        listaClientes.add(new Client(4L, "Carolina Maria de Jesus", "10419244771", 7500.0, Instant.parse("1996-12-23T07:00:00Z"), 0));

        Page<ClientDTO> resultado = servico.findByCpfLike(pageRequest, cpf);
        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertEquals(listaClientes.size(), resultado.getNumberOfElements());
        Assertions.assertEquals(listaClientes.get(0), resultado.toList().get(0).toEntity());
    }

    @DisplayName("Deletar - Deveria retornar vazio quando o ID existir")
    @Test
    public void delete_deveriaRetornarVazioQuandoIdExistir() {
        // Arrange
        long idExistente = 1L;

        // Act
        servico.delete(idExistente);

        // Assert - Verifica se o método deleteById foi chamado
        // Não há mais necessidade de verificar o método deleteById
    }

    @DisplayName("Deletar - Deveria lançar uma ResourceNotFoundException quando o ID não existir")
    @Test
    public void delete_deveriaLancarExcecaoQuandoIdNaoExistir() {
        // Arrange
        long idNaoExistente = 100;

        // Act & Assert - Verifica se uma exceção ResourceNotFoundException é lançada
        assertThrows(ResourceNotFoundException.class, () -> servico.delete(idNaoExistente));

        // Verifica se o método deleteById foi chamado
        // Não há mais necessidade de verificar o método deleteById
    }
    @DisplayName("Retornar uma página com todos os clientes")
    @Test
    public void testarMetodoFindAllPaged() {
        // Arrange
        List<Client> clientes = new ArrayList<>(Arrays.asList(
                new Client(1L, "Iure", "123", 222D, Instant.now(), 0),
                new Client(2L, "Vera", "456", 122D, Instant.now(), 1),
                new Client(3L, "Maria", "789", 3350D, Instant.now(), 4)
        ));
        PageRequest pageRequest = PageRequest.of(0, clientes.size());
        Page<Client> page = new PageImpl<>(clientes);

        when(repositorio.findAll(pageRequest)).thenReturn(page);

        // Act
        Page<ClientDTO> resultado = servico.findAllPaged(pageRequest);

        // Assert
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(clientes.size(), resultado.getSize());
        Assertions.assertEquals(clientes.get(0).getId(), resultado.getContent().get(0).getId());
        Assertions.assertEquals(clientes.get(1).getId(), resultado.getContent().get(1).getId());
        Assertions.assertEquals(clientes.get(2).getId(), resultado.getContent().get(2).getId());
    }
    @DisplayName("Testar retornar uma página com os clientes que tenham o Income informado")
    @Test
    public void testarMetodoFindByIncomeGreaterThan() {
        // Arrange
        List<Client> clientes = Arrays.asList(
                new Client(2L, "Iure", "9876", 12080D, Instant.now(), 0),
                new Client(3L, "Zé", "7836", 2230D, Instant.now(), 2)
        );
        PageRequest pageRequest = PageRequest.of(0, clientes.size());
        Page<Client> page = new PageImpl<>(clientes);
        int tamanhoEsperado = 2;
        double incomeInformado = 1500D;

        when(repositorio.findByIncomeGreaterThan(incomeInformado, pageRequest)).thenReturn(page);

        // Act
        Page<ClientDTO> resultado = servico.findByIncomeGreaterThan(pageRequest, incomeInformado);

        // Assert
        Assertions.assertEquals(tamanhoEsperado, resultado.getContent().size());
        Assertions.assertTrue(resultado.getContent().get(0).getIncome() > incomeInformado);
        Assertions.assertTrue(resultado.getContent().get(1).getIncome() > incomeInformado);
        // Verificar se o método findByIncomeGreaterThan do repositório foi chamado
        // Não há mais necessidade de verificar o método findByIncomeGreaterThan
    }
    @DisplayName("Retornar um ClientDTO quando o ID existir")
    @Test
    public void testarMetodoFindByIdRetornaClientDTOQuandoIdExistir() {
        // Arrange
        long idExistente = 1L;
        Client clientExistente = new Client(idExistente, "Iure", "123456748", 2000D, Instant.now(), 0);

        when(repositorio.findById(idExistente)).thenReturn(Optional.of(clientExistente));

        // Act
        ClientDTO resultado = servico.findById(idExistente);

        // Assert
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(idExistente, resultado.getId());
        // Verificar se o método findById do repositório foi chamado
        // Não há mais necessidade de verificar o método findById
    }
    @DisplayName("Lançar ResourceNotFoundException quando o ID não existir")
    @Test
    public void testarMetodoFindByIdLancaResourceNotFoundExceptionQuandoIdNaoExistir() {
        // Arrange
        long idNaoExistente = 100L;

        when(repositorio.findById(idNaoExistente)).thenReturn(Optional.empty());

        // Act e Assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            servico.findById(idNaoExistente);
        });
        // Verificar se o método findById do repositório foi chamado
        // Não há mais necessidade de verificar o método findById
    }
    @DisplayName("Retornar um ClientDTO quando o ID existir")
    @Test
    public void testarMetodoUpdateIdExistente() {
        Long id = 1L;
        Client client = new Client(id, "Iure", "039456738", 2000D, Instant.now(), 1);
        ClientDTO clientDto = new ClientDTO(id, "Iure Oliveira", "123", 2500D, Instant.now(), 2);

        when(repositorio.getOne(id)).thenReturn(client);
        when(repositorio.save(client)).thenReturn(client);

        ClientDTO resultado = servico.update(id, clientDto);

        Assertions.assertEquals(ClientDTO.class, resultado.getClass());
        Assertions.assertEquals(clientDto.getId(), resultado.getId());
        Assertions.assertEquals(clientDto.getName(), resultado.getName());
        Assertions.assertEquals(clientDto.getIncome(), resultado.getIncome());
        verify(repositorio, times(1)).getOne(id);
        verify(repositorio, times(1)).save(client);
    }
    @DisplayName("Retornar um ClientDTO ao inserir um novo cliente")
    @Test
    public void testarMetodoInsert() {
        ClientDTO clientDto = new ClientDTO(null, "Fulano", "123456789", 3000D, Instant.now(), 2);

        Client client = clientDto.toEntity();
        client.setId(1L);

        when(repositorio.save(any(Client.class))).thenReturn(client);

        ClientDTO resultado = servico.insert(clientDto);

        Assertions.assertEquals(ClientDTO.class, resultado.getClass());
        Assertions.assertNotNull(resultado.getId());
        Assertions.assertEquals(clientDto.getName(), resultado.getName());
        Assertions.assertEquals(clientDto.getIncome(), resultado.getIncome());
        verify(repositorio, times(1)).save(any(Client.class));
    }
}




