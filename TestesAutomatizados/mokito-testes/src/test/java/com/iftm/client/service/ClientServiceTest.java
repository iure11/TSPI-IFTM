package com.iftm.client.service;

import com.iftm.client.dto.ClientDTO;
import com.iftm.client.entities.Client;
import com.iftm.client.repositories.ClientRepository;
import com.iftm.client.services.ClientService;
import com.iftm.client.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {


    @InjectMocks
    private ClientService servico;

    @Mock
    private ClientRepository repositorio;

    @DisplayName("Testar se o método deleteById apaga um registro e não retorna outras informações")
    @Test
    public void testarApagarPorIdTemSucessoComIdExistente() {
        //cenário
        long idExistente = 1;
        //configurando mock : definindo que o método deleteById não retorna nada para esse id.
        doNothing().when(repositorio).deleteById(idExistente);

        Assertions.assertDoesNotThrow(() -> {
            servico.delete(idExistente);
        });
        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idExistente);

    }

    @DisplayName("Testar se o método deleteById retorna exception para idInexistente")
    @Test
    public void testarApagarPorIdGeraExceptionComIdInexistente() {
        //cenário
        long idNaoExistente = 100;
        //configurando mock : definindo que o método deleteById retorna uma exception para esse id.
        doThrow(ResourceNotFoundException.class).when(repositorio).deleteById(idNaoExistente);

        assertThrows(ResourceNotFoundException.class, () -> servico.delete(idNaoExistente));

        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idNaoExistente);

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
        Client clienteOito = new Client(8L, "Toni Morrison", "10219344681", 10000.0, Instant.parse("1940-02-23T07:00:00Z"), 0);

        PageRequest pagina = PageRequest.of(paginaApresentada, linhasPorPagina,
                Sort.Direction.valueOf(ordemOrdenacao), campoOrdenacao);

        //configurar o Mock
        List<Client> lista = new ArrayList<>();
        lista.add(clienteSete);
        lista.add(clienteQuatro);
        Page<Client> paginaEsperada = new PageImpl<>(lista, pagina, 3);
        System.out.println(paginaEsperada.toList().size());
        when(repositorio.findByIncomeGreaterThan(entrada, pagina)).thenReturn(paginaEsperada);

        //testar se o método da service não retorna erro.
        //AtomicReference<Page<ClientDTO>> page = null;
        //Assertions.assertDoesNotThrow(()->{
        //page.set(servico.findByIncomeGreaterThan(pagina, entrada));},"Exception identificada");

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
        listaClientes.add(new Client(4l, "Carolina Maria de Jesus", "10419244771", 7500.0, Instant.parse("1996-12-23T07:00:00Z"), 0));

        Page<Client> clientes = new PageImpl<Client>(listaClientes);

        when(repositorio.findByCpfLike(cpf, pageRequest)).thenReturn(clientes);
        Page<ClientDTO> resultado = servico.findByCpfLike(pageRequest, cpf);
        Assertions.assertFalse(resultado.isEmpty());
        assertEquals(listaClientes.size(), resultado.getNumberOfElements());
        assertEquals(listaClientes.get(0), resultado.toList().get(0).toEntity());
        Mockito.verify(repositorio, Mockito.times(1)).findByCpfLike(cpf, pageRequest);
    }

    // Exemplos feitos por Iure

    @Test
    @DisplayName("Deletar - Deveria retornar vazio quando o ID existir")
    public void delete_deveriaRetornarVazioQuandoIdExistir() {
        // Arrange
        long idExistente = 1L;
        doNothing().when(repositorio).deleteById(idExistente);

        // Act
        servico.delete(idExistente);

        // Assert - Verifica se o método deleteById foi chamado
        Mockito.verify(repositorio,  Mockito.times(1)).deleteById(idExistente);
    }

    @Test
    @DisplayName("Deletar - Deveria lançar uma ResourceNotFoundException quando o ID não existir")
    public void delete_deveriaLancarExcecaoQuandoIdNaoExistir() {
        // Arrange
        long idNaoExistente = 100;
        doThrow(ResourceNotFoundException.class).when(repositorio).deleteById(idNaoExistente);

        // Act & Assert - Verifica se uma exceção ResourceNotFoundException é lançada
        assertThrows(ResourceNotFoundException.class, () -> servico.delete(idNaoExistente));

        // Verifica se o método deleteById foi chamado
        Mockito.verify(repositorio).deleteById(idNaoExistente);
    }
    @Test
    @DisplayName("Retornar uma página com todos os clientes")
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

        // Verificar se o método findAll do repositório foi chamado
        verify(repositorio, times(1)).findAll(pageRequest);
    }

    @Test
    @DisplayName("Testar retornar uma página com os clientes que tenham o Income informado")
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

        Mockito.when(repositorio.findByIncomeGreaterThan(incomeInformado, pageRequest)).thenReturn(page);

        // Act
        Page<ClientDTO> resultado = servico.findByIncomeGreaterThan(pageRequest, incomeInformado);

        // Assert
        Assertions.assertEquals(tamanhoEsperado, resultado.getContent().size());
        Assertions.assertTrue(resultado.getContent().get(0).getIncome() > incomeInformado);
        Assertions.assertTrue(resultado.getContent().get(1).getIncome() > incomeInformado);
        Mockito.verify(repositorio, times(1)).findByIncomeGreaterThan(incomeInformado, pageRequest);
    }

    @Test
    @DisplayName("Retornar um ClientDTO quando o ID existir")
    public void testarMetodoFindByIdRetornaClientDTOQuandoIdExistir() {
        // Arrange
        long idExistente = 1L;
        Client clientExistente = new Client(idExistente, "Iure", "123456748", 2000D, Instant.now(), 0);

        Mockito.when(repositorio.findById(idExistente)).thenReturn(Optional.of(clientExistente));

        // Act
        ClientDTO resultado = servico.findById(idExistente);

        // Assert
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(idExistente, resultado.getId());
        Mockito.verify(repositorio, Mockito.times(1)).findById(idExistente);
    }

    @Test
    @DisplayName("Lançar ResourceNotFoundException quando o ID não existir")
    public void testarMetodoFindByIdLancaResourceNotFoundExceptionQuandoIdNaoExistir() {
        // Arrange
        long idNaoExistente = 100L;

        Mockito.when(repositorio.findById(idNaoExistente)).thenReturn(Optional.empty());

        // Act e Assert
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            servico.findById(idNaoExistente);
        });
        Mockito.verify(repositorio, Mockito.times(1)).findById(idNaoExistente);
    }

    @Test
    @DisplayName("Retornar um ClientDTO quando o ID existir")
    public void testarMetodoUpdateIdExistente() {
        Long id = 1L;
        // Criação do cliente existente com ID e nome "Iure"
        Client client = new Client(id, "Iure", "039456738", 2000D, Instant.now(), 1);
        // Criação do DTO com as informações atualizadas (novo nome "Iure Oliveira")
        ClientDTO clientDto = new ClientDTO(id, "Iure Oliveira", "123", 2500D, Instant.now(), 2);

        // Configuração do mock para o método getOne, retornando o cliente existente
        Mockito.when(repositorio.getOne(id)).thenReturn(client);
        // Configuração do mock para o método save, retornando o mesmo cliente
        Mockito.when(repositorio.save(client)).thenReturn(client);

        // Atualiza o cliente existente com as informações do DTO
        ClientDTO resultado = servico.update(id, clientDto);

        // Verificações de assertiva
        Assertions.assertEquals(ClientDTO.class, resultado.getClass()); // Verifica se o resultado é uma instância de ClientDTO
        Assertions.assertEquals(clientDto.getId(), resultado.getId()); // Verifica se o ID no resultado corresponde ao ID do DTO
        Assertions.assertEquals(clientDto.getName(), resultado.getName()); // Verifica se o nome no resultado corresponde ao nome do DTO
        Assertions.assertEquals(clientDto.getIncome(), resultado.getIncome()); // Verifica se o income no resultado corresponde ao income do DTO
        Mockito.verify(repositorio, times(1)).getOne(id); // Verifica se o método getOne foi chamado uma vez com o ID correto
        Mockito.verify(repositorio, times(1)).save(client); // Verifica se o método save foi chamado uma vez com o cliente correto
    }

    @Test
    @DisplayName("Retornar um ClientDTO ao inserir um novo cliente")
    public void testarMetodoInsert() {
        // Criação do DTO com as informações do novo cliente
        ClientDTO clientDto = new ClientDTO(null, "Fulano", "123456789", 3000D, Instant.now(), 2);

        // Criação do cliente com base no DTO
        Client client = clientDto.toEntity();
        // Definição do ID simulando a inserção no repositório
        client.setId(1L);

        // Configuração do mock para retornar o cliente inserido
        Mockito.when(repositorio.save(Mockito.any(Client.class))).thenReturn(client);

        // Inserção do novo cliente e obtenção do resultado
        ClientDTO resultado = servico.insert(clientDto);

        // Verificações de assertiva
        Assertions.assertEquals(ClientDTO.class, resultado.getClass()); // Verifica se o resultado é uma instância de ClientDTO
        Assertions.assertNotNull(resultado.getId()); // Verifica se o ID no resultado não é nulo
        Assertions.assertEquals(clientDto.getName(), resultado.getName()); // Verifica se o nome no resultado corresponde ao nome do DTO
        Assertions.assertEquals(clientDto.getIncome(), resultado.getIncome()); // Verifica se o income no resultado corresponde ao income do DTO
        Mockito.verify(repositorio, times(1)).save(Mockito.any(Client.class)); // Verifica se o método save foi chamado uma vez com um cliente como argumento
    }
















}


