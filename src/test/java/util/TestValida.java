package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestValida {

    private Valida valida = null;

    /**
     * Instância uma classe de validação.
     */
    @BeforeAll
    public void inicializa() {
        valida = new Valida();
    }

    /**
     * Testa CPF válido.
     */
    @Test
    public void testValidaCPFValido1() {
        assertTrue(valida.validaCPF("11111111111"));
    }

    /**
     * Testa CPF válido.
     */
    @Test
    public void testValidaCPFValido2() {
        assertTrue(valida.validaCPF("84807125206"));
    }

    /**
     * Testa CPF válido.
     */
    @Test
    public void testValidaCPFValido3() {
        assertTrue(valida.validaCPF("63883136395"));
    }

    /**
     * Testa CPF inválido com final 1.
     */
    
    /**
     * Testa CPF inválido final 2.
     */
    
    /**
     * Testa CPF com problema na conversão (com letras juntos) Ex.0065XAB22050.
     */

    /**
     * Testa CPF com problema na quantidade de caracteres  Ex.11111.
     */

    /**
     * Finaliza a classe de validação.
     */
    @AfterAll
    public void finaliza() {
        valida = null;
    }
}
