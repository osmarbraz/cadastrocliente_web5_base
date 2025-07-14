package controle.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Valida;
import entidade.Cliente;

public class ClienteIncluir extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang=\"pt-br\" xml:lang=\"pt-br\"><head><title>Cadastro de Cliente - Incluir</title></head><body>");
        out.println("<h1>Cadastro de Cliente - Incluir</h1>");

        Cliente cliente = new Cliente();
        cliente.setclienteId(request.getParameter("ClienteId"));
        cliente.setNome(request.getParameter("Nome"));        
        cliente.setCpf(request.getParameter("CPF"));
        
        Valida valida = new Valida();
        boolean cpfValido = valida.validaCPF(cliente.getCpf());
        if (cpfValido == true) {
            boolean resultado = cliente.inserir();
            if (resultado == true) {
                out.print("<span class='mensagemIncluir'>Inclus&atilde;o realizada com sucesso.</span><p>");
            } else {
                out.print("<span class='mensagemIncluir'>Inclus&atilde;o n&atilde;o realizada.</span><p>");
            }
        } else {
            out.print("CPF Inv&aacute;lido!");
        }
        out.print("<a href=\"" + request.getContextPath() + "/FrmClienteIncluir.jsp\"> Incluir </a> - <a href=\"" + request.getContextPath() + "/menu.jsp\"> Menu </a> <p>");

        out.println("</body></html>");
        out.close();
    }
}