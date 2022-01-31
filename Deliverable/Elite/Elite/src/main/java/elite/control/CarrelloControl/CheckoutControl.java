package elite.control.CarrelloControl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Cliente;
import elite.bean.Indirizzo;
import elite.bean.Pagamento;
import elite.model.IndirizzoModel;
import elite.model.PagamentoModel;

@WebServlet("/cliente/CheckoutControl")
public class CheckoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		Cliente c=(Cliente) request.getSession().getAttribute("Cliente");
		PagamentoModel pm = new PagamentoModel();
		IndirizzoModel im = new IndirizzoModel();

		String redirectedPage = "/cliente/CheckoutCarrello.jsp";

		try {
			ArrayList<Pagamento> p= pm.findByClient(String.valueOf(c.getId()));
			ArrayList<Indirizzo> i= im.findByClient(String.valueOf(c.getId()));
			request.setAttribute("pagamenti", p);
			request.setAttribute("indirizzi", i);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	

		redirectedPage = response.encodeURL(redirectedPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(redirectedPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
