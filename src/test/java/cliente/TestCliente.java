package cliente;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import entidade.Cliente;

public class TestCliente {

    /**
     * Testa o construtor sem argumentos do cliente.
     */
    @Test
    public void testCliente() {
        Cliente instancia = new Cliente();
        assertTrue("".equals(instancia.getclienteId()) && "".equals(instancia.getNome()) && "".equals(instancia.getCpf()));
    }

    /**
     * Testa a inclusão com o clienteId do tipo inteiro.
     */
    
    /**
     * Testa o método paraString.
     */
        
    /**
     * Testa o método inserir.
     */
    
    /**
     * Testa o método excluir.
     */
    
    /**
     * Testa o método alterar.
     */
       
    /**
     * Testa o método aplicarFiltro.
     */
   
    /**
     * Testa o método getLista.
     */
        
    /**
     * Testa o método abrir.
     */
}
