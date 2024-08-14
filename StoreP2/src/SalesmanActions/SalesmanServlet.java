package SalesmanActions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalesmanServlet
 */
@WebServlet("/SalesmanServlet")
public class SalesmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String ns = request.getParameter("name");
		String cs = request.getParameter("city");
		String cms = request.getParameter("comission");

		Salesman s = new Salesman();
		s.setNomeSalesman(ns);
		s.setCidadeSalesman(cs);
		s.setComissaoSalesman(Integer.valueOf(cms));
		
		int status = Salesmans.salvarSalesman(s);
		if(status > 0) {
		out.print("<p>Salesman salvo com sucesso!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		} else { out.println("Erro no cadastro."); }

		out.close();
	}

}
