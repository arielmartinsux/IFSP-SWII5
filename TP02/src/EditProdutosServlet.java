// Nome do aluno: Gabriel Martins Alves da Silva - CB3021521

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProdutosServlet
 */
@WebServlet("/EditProdutosServlet")
public class EditProdutosServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String nome = request.getParameter("nome");
		String uc = request.getParameter("unidadecompra");
		String des = request.getParameter("descricao");
		String qpm = request.getParameter("qtdprevistomes");
		String pmc = request.getParameter("precomaxcomprado");

		Produto p = new Produto();
		p.setId(id);
		p.setNome(nome);
		p.setUnidadeCompra(Integer.valueOf(uc));
		p.setDescricao(des);
		p.setQtdPrevistoMes(Integer.valueOf(qpm));
		p.setPrecoMaxComprado(Integer.valueOf(pmc));

		int status = Produtos.updateProduto(p);
		if(status > 0) { response.sendRedirect("ViewProdutosServlet"); } else { out.println("Erro de gravação no Banco de Dados."); }

		out.close();
		}
}
