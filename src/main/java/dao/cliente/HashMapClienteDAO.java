package dao.cliente;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

import dao.HashMapDAOFactory;
import entidade.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementa a persitência para cliente utilizando HashMap.
 *
 * @author osmarbraz
 */
public class HashMapClienteDAO extends HashMapDAOFactory implements ClienteDAO {

    private static final Logger LOGGER = Logger.getLogger(HashMapClienteDAO.class.getName());

    private static final Map<String, Cliente> mapa = new HashMap<>();

    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getclienteId());
            if (!tem) {
                mapa.put(cliente.getclienteId(), cliente);
                return true;
            } else {
                LOGGER.log(Level.SEVERE, "Problema em inserir o registro!");
            }
        }
        return false;
    }

    @Override
    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getclienteId());
            if (tem) {
                Cliente c = mapa.get(cliente.getclienteId());
                c.setNome(cliente.getNome());
                c.setCpf(cliente.getCpf());
                return 1;
            } else {
                LOGGER.log(Level.SEVERE, "Problema em altear o registro!");
            }
        }
        return 0;
    }

    @Override
    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getclienteId());
            if (tem) {
                mapa.remove(cliente.getclienteId());
                return 1;
            } else {
                LOGGER.log(Level.SEVERE, "Problema em excluir o registro!");
            }
        }
        return 0;
    }

    @Override
    public List<Cliente> getLista() {
        List<Cliente> lista = new LinkedList<>();
        Iterator<Cliente> it = mapa.values().iterator();
        while (it.hasNext()) { //Avança enquanto tiver objetos
            Cliente c = it.next();
            lista.add(c);
        }
        return lista;
    }

    @Override
    public List<Cliente> aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            List<Cliente> lista = new LinkedList<>();
            Iterator<Cliente> it = mapa.values().iterator();

            while (it.hasNext()) { //Avança enquanto tiver objetos
                Cliente c = it.next();

                //Filtro para clienteId
                if (c.getclienteId().equalsIgnoreCase(cliente.getclienteId())) {
                    lista.add(c);
                }

                //Filtro para nome
                if (c.getclienteId().equalsIgnoreCase(cliente.getclienteId())) {
                    lista.add(c);
                }

                //Filtro para CPF
                if (c.getCpf().equalsIgnoreCase(cliente.getCpf())) {
                    lista.add(c);
                }
            }
            return lista;
        } else {
            return Collections.emptyList();
        }
    }
}
