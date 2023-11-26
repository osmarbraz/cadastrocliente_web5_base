package dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

import entidade.Cliente;
import dao.cliente.ClienteDAO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOInclusaoChavePrimaria {

    Cliente cliente;

    /**
     * Instância os objetos cliente para testes.
     */
    @BeforeAll
    public void inicializa() {
        cliente = new Cliente("123", "Teste Chave Primaria", "11111111111");
    }

    /**
     * Testa SQLite Inserção com violação de chave.
     */
    

    /**
     * Testa HASHMAP Inserção com violação de chave.
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
