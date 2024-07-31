// Nome do aluno: Gabriel Martins Alves da Silva - CB3021521

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProdutosServlet
 */
@WebServlet("/SaveProdutosServlet")
public class SaveProdutosServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String uc = request.getParameter("unidadecompra");
		String des = request.getParameter("descricao");
		String qpm = request.getParameter("qtdprevistomes");
		String pmc = request.getParameter("precomaxcomprado");

		Produto p = new Produto();
		p.setNome(nome);
		p.setUnidadeCompra(Integer.parseInt(uc));
		p.setDescricao(des);
		p.setQtdPrevistoMes(Integer.parseInt(qpm));
		p.setPrecoMaxComprado(Integer.parseInt(pmc));

		int status = Produtos.salvarProduto(p);
		if(status > 0) {
		out.print("<p style=\"color: white; width: 100%; display: flex; justify-content: center; align-items: center; padding: 1em; background-color: #a7c957\">Produto salvo no Banco de Dados!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		} else { out.println("Erro de gravação no Banco de Dados."); }
		
		out.close();
	}
}
