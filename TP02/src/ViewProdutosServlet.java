// Nome do aluno: Gabriel Martins Alves da Silva - CB3021521

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProdutosServlet
 */
@WebServlet("/ViewProdutosServlet")
public class ViewProdutosServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			
		out.println("<a href='index.html'>Adicionar novo produto</a>");
		out.println("<h1 style=\"font-family:sans-serif\">Lista de produtos</h1>");

		List<Produto> list = Produtos.listarProdutos();

		out.print("<table border='1' style=\"font-family:sans-serif\" width='100%'");
		out.print("<tr><th>Id</th><th>Nome do Produto</th><th>Unidades p/ Compra</th><th>Descrição</th><th>Qtd. de compras mensais previstas</th><th>Preço Máx. Comprado</th><th>Editar</th><th>Deletar</th></tr>");

		for(Produto p:list){
		out.print("<tr><td>"+p.getId()+"</td><td>"+p.getNome()+"</td><td>"+p.getUnidadeCompra()+"</td><td>"+p.getDescricao()+"</td><td>"+p.getQtdPrevistoMes()+"</td><td>"+p.getPrecoMaxComprado()+"</td><td><a href='EditHTMLServlet?id="+p.getId()+"'>Editar</a></td><td><a href='DelProdutosServlet?id="+p.getId()+"'>Deletar</a></td></tr>");}
		out.print("</table>");

		out.close();
	}
}
