package dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOAlteracao {

    Cliente cliente;
    Cliente clienteNaoExistente;

    @BeforeAll
    public void inicializa() {
        cliente = new Cliente("131", "TesteAlteracao", "11111111111");
        clienteNaoExistente = new Cliente("879", "Cliente Nao Existente", "11111111111");
    }

    /**
     * Testa a alteração do nome de um cliente existente no SQLite.
     */
    @Test
    public void testAlteracaoNome1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            DAO.alterar(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }
    
    /**
     * Testa a alteração do cpf de um cliente existente no SQLite.
     */
   
    /**
     * Testa a alteração de um cliente não existente no SQLite.
     */
   
    /**
     * Testa a alteração de um cliente nullo no SQLite.
     */
   
    /**
     * Testa a alteração do campo nome de um cliente no Hashmap.
     */
    @Test
    public void testAlteracao2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.Hashmap);
        ClienteDAO DAO = factory.getClienteDAO();
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            DAO.alterar(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }

    /**
     * Testa a alteração de um cliente não existente no Hashmap.
     */
  
    /**
     * Testa a alteração de um cliente nulo no Hashmap.
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
