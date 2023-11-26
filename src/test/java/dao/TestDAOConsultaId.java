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
public class TestDAOConsultaId {

    Cliente cliente;
    Cliente clienteNaoExistente;

    /**
     * Instância os objetos cliente para testes.
     */
    @BeforeAll
    public void inicializa() {
        cliente = new Cliente("131", "Teste Consulta", "11111111111");
        clienteNaoExistente = new Cliente("999", "Cliente Nao Existente", "11111111111");
    }
    
    /**
     * Consulta SQLite cliente id existente.
     */
    @Test
    public void testConsulta1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setclienteId(cliente.getclienteId());
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
     * Consulta SQLite cliente id não existente.
     */
  
    /**
     * Consulta SQLite cliente nulo no método aplicarFiltro.
     */
  
    /**
     * Consulta HASHMAP cliente id existente.
     */
   
    /**
     * Consulta HASHMAP cliente id inexistente.
     */
   
    /**
     * Consulta HASHMAP cliente nulo no método aplicarFiltro.
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
