package dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOInclusao {

    Cliente cliente;

    /**
     * Instância os objetos cliente para testes.
     */
    @BeforeAll
    public void inicializa() {
        cliente = new Cliente("131", "Teste", "11111111111");
    }

    /**
     * Testa a inclusão SQLite cliente novo.
     * @throws Exception 
     */

    /**
     * Testa SQLite a inclusão cliente null.
     */

    /**
     * Testa HASHMAP a inclusão cliente novo.
     * @throws Exception 
     */

    /**
     * Inclusão HASHMAP cliente null.
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
