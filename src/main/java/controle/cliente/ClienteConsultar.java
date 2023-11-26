package controle.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import entidade.Cliente;

public class ClienteConsultar extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html lang=\"pt-br\" xml:lang=\"pt-br\"><head><title>Cadastro de Cliente - Consultar</title></head><body>");
        out.println("<h1>Cadastro de Cliente - Consultar</h1>");

        Cliente cliente = new Cliente();
        cliente.setclienteId(request.getParameter("ClienteId"));
        boolean resultado = cliente.abrir();
        if (resultado == true) {
            out.print("<span class='mensagemConsultar'>Cliente encontrado.</span><p>");
            out.print(" Cliente : " + cliente.getclienteId() + " <br> ");
            out.print(" Nome : " + cliente.getNome() + " <br> ");
            out.print(" Cpf : " + cliente.getCpf() + " <br> <p>");
        } else {
            out.print("<span class='mensagemConsultar'>Cliente n&atilde;o encontrado.</span><p>");
        }
        out.print("<a href =\"" + request.getContextPath() + "/FrmClienteConsultar.jsp\"> Consultar </a> - <a href=\"" + request.getContextPath() + "/menu.jsp\"> Menu </a> <p>");

        out.println("</body></html>");
        out.close();
    }
}
