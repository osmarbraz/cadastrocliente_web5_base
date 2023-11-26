package dao;

import dao.cliente.ClienteDAO;

/**
 * Abstrai as fontes de dados do sistema.
 *
 * @author osmarbraz
 */
public abstract class DAOFactory {

    //Tipos de Fonte de Dados suportados pela Factory
    public static final int SQLITE = 1;
    public static final int Hashmap = 2;
    
    //Retorna o DAO instanciado
    public abstract ClienteDAO getClienteDAO();

    /**
     * Retorna a Factory do tipo especificado
     *
     * @param qualfabrica Especifica a fábrica a ser selecionada.
     * @return Um fábrica.
     */
    public static DAOFactory getDAOFactory(int qualfabrica) {
        switch (qualfabrica) {
            case SQLITE:
                return new SQLiteDAOFactory();
            case Hashmap:
                return new HashMapDAOFactory();
            default:
                return null;
        }
    }
}
