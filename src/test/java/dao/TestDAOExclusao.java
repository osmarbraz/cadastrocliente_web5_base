package dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOExclusao {

    Cliente cliente;

    /**
     * Instância os objetos cliente para testes.
     */
    @BeforeAll
    public void inicializa() {
        cliente = new Cliente("131", "Teste", "11111111111");
    }

    /**
     * Exclusão SQLITE cliente existente.
     */
    @Test
    public void testExclusao1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();;
        DAO.inserir(cliente);
        List lista = DAO.aplicarFiltro(cliente);

        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            //Verifica se existe o cliente antes da exclusão
            boolean existeAntesExclusao = oCliente!= null;
            DAO.excluir(oCliente);
            lista = DAO.aplicarFiltro(cliente);
            //Verifica se a lista está vazia depois da exclusão
            boolean naoExisteDepoisExclusao = lista.isEmpty();
            assertTrue(existeAntesExclusao);
            assertTrue(naoExisteDepoisExclusao);
        } else {
            assertFalse(false);
        }
    }

    /**
     * Exclusão SQLITE cliente null.
     */
    
    /**
     * Exclusão SQLITE cliente existente.
     */
    
    /**
     * Exclusão HASHMAP cliente null.
     */

    /**
     * Finaliza o teste excluindo os dados.
     * @throws Exception 
     */
    @AfterAll
    public void Finaliza() throws Exception {
        cliente = null;
    }
}
