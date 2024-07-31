// Nome do aluno: Gabriel Martins Alves da Silva - CB3021521

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelProdutosServlet
 */
@WebServlet("/DelProdutosServlet")
public class DelProdutosServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		Produtos.deletarProduto(id);
		
		response.sendRedirect("ViewProdutosServlet");
	}
}
