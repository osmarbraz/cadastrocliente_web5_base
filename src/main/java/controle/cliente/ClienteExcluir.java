package controle.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidade.Cliente;

public class ClienteExcluir extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang=\"pt-br\" xml:lang=\"pt-br\"><head><title>Cadastro de Cliente - Excluir</title></head><body>");
        out.println("<h1>Cadastro de Cliente - Excluir</h1>");

        Cliente cliente = new Cliente();
        cliente.setclienteId(request.getParameter("ClienteId"));
        int resultado = cliente.excluir();
        if (resultado != 0) {
            out.print("<span class='mensagemExcluir'>Exclus&atilde;o realizada com sucesso.</span><p>");
        } else {
            out.print("<span class='mensagemExcluir'>Exclus&atilde;o n&atilde;o realizada.</span><p>");
        }
        out.print("<a href=\"" + request.getContextPath() + "/FrmClienteExcluir.jsp\"> Excluir </a> - <a href=\"" + request.getContextPath() + "/menu.jsp\"> Menu </a> <p>");

        out.println("</body></html>");
        out.close();
    }
}
