// Nome do aluno: Gabriel Martins Alves da Silva - CB3021521

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditHTMLServlet
 */
@WebServlet("/EditHTMLServlet")
public class EditHTMLServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Atualizar Produto</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Produto p = Produtos.getProdutoByID(id);

		out.print("<form action='EditProdutosServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+p.getId()+"'/></td></tr>");
		out.print("<tr><td>Nome do Produto:</td><td><input type='text' name='nome' value='"+p.getNome()+"'/></td></tr>");
		out.print("<tr><td>Unidades p/ Compra:</td><td><input type='text' name='unidadecompra' value='"+p.getUnidadeCompra()+"'/></td></tr>");
		out.print("<tr><td>Descrição:</td><td><input type='text' name='descricao' value='"+p.getDescricao()+"'/></td></tr>");
		out.print("<tr><td>Qtd. de compras mensais prevista:</td><td><input type='text' name='qtdprevistomes' value='"+p.getQtdPrevistoMes()+"'/></td></tr>");
		out.print("<tr><td>Preço Máx. Comprado:</td><td><input type='text' name='precomaxcomprado' value='"+p.getPrecoMaxComprado()+"'/></td></tr>");	
		out.print("<tr><td colspan='2'><input type='submit' value='Editar e Salvar'/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}
