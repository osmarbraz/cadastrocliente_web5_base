<%@page import="java.util.List"%>
<%@page import="entidade.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>Cadastro de Cliente - Listar</title></head><body>
        <h1>Cadastro de Cliente - Listar</h1>
        <table border="1">    
            <td>ClienteId</td> <td>Nome</td><td>Cpf</td>
            <% 	Cliente cliente = new Cliente();
                List<Cliente> clientes = cliente.getLista();
                for (Cliente aux : clientes) {%>                    			
            <tr>                   
                <td><%=aux.getclienteId()%></td><td><%=aux.getNome()%></td><td><%=aux.getCpf()%></td                   
            </tr>  
            <% }%>
        </table>
        <br>
        <a href="<%=request.getContextPath()%>/menu.jsp"> Menu </a> <p>
    </body>
</html>
