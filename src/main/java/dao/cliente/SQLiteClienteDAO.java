package dao.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.List;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.logging.Level;

import dao.SQLiteDAOFactory;
import entidade.Cliente;

/**
 * Implementa a persistência de cliente utilizando SQLite.
 *
 * @author osmarbraz
 */
public class SQLiteClienteDAO extends SQLiteDAOFactory implements ClienteDAO, SQLiteClienteMetaDados {

    private static final Logger LOGGER = Logger.getLogger(SQLiteClienteDAO.class.getName());

    public SQLiteClienteDAO() {
        criar();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Cliente> select(String sql) {
        List<Cliente> lista = new LinkedList<Cliente>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setclienteId(rs.getString("CLIENTEID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                lista.add(cliente);
            }
            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro no select:{0}", e.toString());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Erro no fechamento do rs:{0}", e.toString());
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Erro no fechamento do stmt:{0}", e.toString());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Erro no fechamento do con:{0}", e.toString());
                }
            }
        }
        return lista;
    }

    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            boolean res = false;
            StringBuilder sql = new StringBuilder();
            try {
                sql.append("insert into " + Table + "(");
                sql.append(METADADOSINSERT + " ) ");

                sql.append("values ('").append(preparaSQL(cliente.getclienteId()));
                sql.append("','").append(preparaSQL(cliente.getNome()));
                sql.append("','").append(preparaSQL(cliente.getCpf())).append("')");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString()) > 0;
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no inserir:{0}", e.toString());
                res = false;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "Erro no fechamento do stmt:{0}", e.toString());
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "Erro no fechamento do con:{0}", e.toString());
                    }
                }
            }
            return res;
        }
        return false;
    }

    @Override
    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            int res = 0;
            StringBuilder sql = new StringBuilder();
            try {
                sql.append("update " + Table);
                sql.append(" set NOME='").append(cliente.getNome()).append("',");
                sql.append(" CPF='").append(cliente.getCpf()).append("'");
                sql.append(" where " + Table + ".").append(PK[0]).append("='").append(preparaSQL(cliente.getclienteId())).append("'");

                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no alterar:{0}", e.toString());
                res = 0;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "Erro no fechamento do stmt:{0}", e.toString());
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "Erro no fechamento do con:{0}", e.toString());
                    }
                }
            }
            return res;
        }
        return 0;
    }

    @Override
    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            Connection con = null;
            Statement stmt = null;
            StringBuilder sql = new StringBuilder();
            int res = 0;
            try {
                sql.append("delete from " + Table + " where " + Table + ".").append(PK[0]).append(" = '").append(preparaSQL(cliente.getclienteId())).append("'");
                con = getConnection();
                stmt = con.createStatement();
                res = stmt.executeUpdate(sql.toString());
                stmt.close();
                stmt = null;
                con.close();
                con = null;

            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Erro no excluir:{0}", e.toString());
                res = 0;
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "Erro no fechamento do stmt:{0}", e.toString());
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "Erro no fechamento do con:{0}", e.toString());
                    }
                }
            }
            return res;
        }
        return 0;
    }

    @Override
    public List<Cliente> getLista() {
        return select("select " + METADADOSSELECT + " from " + Table + " order by " + Table + "." + PK[0]);
    }

    @Override
    public List<Cliente> aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;

            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("select " + METADADOSSELECT + " from " + Table);

            List<String> filtros = new ArrayList<>();

            if (cliente.getclienteId() != null && !"".equals(cliente.getclienteId())) {
                filtros.add(Table + "." + PK[0] + "='" + preparaSQL(cliente.getclienteId()) + "'");
            }

            if (cliente.getNome() != null && !"".equals(cliente.getNome())) {
                filtros.add(Table + ".NOME like upper('%" + preparaSQL(cliente.getNome()) + "%')");
            }

            if (cliente.getCpf() != null && !"".equals(cliente.getCpf())) {
                filtros.add(Table + ".CPF = '" + preparaSQL(cliente.getCpf()) + "'");
            }

            if (!filtros.isEmpty()) {
                sqlBuilder.append(" where ").append(implode(" and ", filtros));
            }

            sqlBuilder.append(" order by " + Table + ".").append(PK[0]);

            return select(sqlBuilder.toString());
        } else {
            return Collections.emptyList();
        }
    }

    private void criar() {
        Connection con = null;
        Statement stmt = null;
        try {
            con = getConnection();
            stmt = con.createStatement();
            //Cria a tabela senão existir
            stmt.execute("create table IF NOT EXISTS cliente (clienteId integer, nome varchar(100), cpf varchar(11), CONSTRAINT PK_Cliente PRIMARY KEY (clienteID));");
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro no criar:{0}", e.toString());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Erro no fechamento do stmt:{0}", e.toString());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Erro no fechamento do con:{0}", e.toString());
                }
            }
        }
    }
}
