package dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOConsultaCPF {

    Cliente cliente;
    Cliente clienteNaoExistente;

    /**
     * Instância os objetos cliente para testes.
     */
    @BeforeAll
    public void inicializa() {
        cliente = new Cliente("131", "Cliente Existente", "11111111111");
        clienteNaoExistente = new Cliente("999", "Cliente Nao Existente", "");
    }

    /**
     * Teste consulta SQLite cliente existente.
     */
    @Test
    public void testConsulta1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setCpf(cliente.getCpf());
        // Insere os dados da consulta
        DAO.inserir(cliente);
        //Consulta
        List lista = DAO.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    /**
     * Teste consulta SQLite cliente inexistente.
     */

    /**
     * Teste consulta SQLLite cliente nulo no aplicaFiltro.
     */
   
    /**
     * Teste consulta HASHMAP cliente existente.
     */
    
    /**
     * Teste consulta HASHMAP cliente inexistente.
     */

    /**
     * Teste consulta HASHMAP cliente nulo no aplicaFiltro.     
     */
         
    /**
     * Finaliza o teste excluindo os dados.
     * @throws Exception 
     */
    @AfterAll
    public void Finaliza() throws Exception {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);

        factory = DAOFactory.getDAOFactory(DAOFactory.Hashmap);
        DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(cliente);       

        cliente = null;
    }
}
