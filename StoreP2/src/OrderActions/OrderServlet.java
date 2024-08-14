package OrderActions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String ordn = request.getParameter("ordno");
		String purch = request.getParameter("purch_amt");
		String cusid = request.getParameter("cusid");
		String salid = request.getParameter("salid");

		Order o = new Order();
		o.setOrdNo(Integer.parseInt(ordn));
		o.setPurchAmt(Integer.valueOf(purch));
		
		Date dtatual = new Date(System.currentTimeMillis());
		o.setDate(dtatual);
		
		o.setCustomerId(Integer.parseInt(cusid));
		o.setSalesmanId(Integer.parseInt(salid));
		
		int status = Orders.salvarOrder(o);
		if(status > 0) {
		out.print("<p>Order salvo com sucesso!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		} else { out.println("Erro no cadastro."); }

		out.close();
	}

}
