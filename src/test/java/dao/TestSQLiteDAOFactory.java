package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestSQLiteDAOFactory {

    /**
     * Testa se o driver não existe.
     */
   
    /**
     * Testa se a url não existe.
     */
  
    /**
     * Testa se o preparaSQL não existe.
     */
    @Test
    public void testPrepareSQL() {
        SQLiteDAOFactory sqlitedaofactory = new SQLiteDAOFactory();
        String prepara = sqlitedaofactory.preparaSQL(null);
        assertEquals("",prepara);
    }
}
