package CustomerActions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String grade = request.getParameter("grade");
		String salesman_id = request.getParameter("salid");

		Customer c = new Customer();
		c.setNomeCustomer(name);
		c.setCidadeCustomer(city);
		c.setGradeCustomer(Integer.parseInt(grade));
		c.setSalesmanId(Integer.parseInt(salesman_id));
		
		int status = Customers.salvarCostumer(c);
		if(status > 0) {
		out.print("<p>Customer salvo com sucesso!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		} else { out.println("Erro no cadastro."); }

		out.close();
	}

}
