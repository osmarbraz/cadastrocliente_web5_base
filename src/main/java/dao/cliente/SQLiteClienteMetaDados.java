package dao.cliente;

/**
 * Armazena os metadados para a implementação em SQLite.
 *
 * @author osmarbraz
 */
public interface SQLiteClienteMetaDados {

    /**
     * string com o nome da tabela usada no banco
     */
    public static final String Table = "CLIENTE";

    /**
     * vetor de string com as chaves da tabela
     */
    public static final String[] PK = {"CLIENTEID"};

    /**
     * string com os campos para serem utilizados com insert
     */
    public static String METADADOSINSERT = "CLIENTEID, NOME, CPF ";

    /**
     * Retorna uma string com os campos para serem utilizados com select
     */
    public static String METADADOSSELECT
            = Table + ".CLIENTEID, "
            + Table + ".NOME, "
            + Table + ".CPF";
}
