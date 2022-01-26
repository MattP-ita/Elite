package elite.control.VinileControl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.model.VinileModel;

@WebServlet("/VisualizzazioneDettagliVinileControl")
public class VisualizzazioneDettagliVinileControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzazioneDettagliVinileControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		VinileModel vm = new VinileModel();
		String redirectedPage = "/Catalogo.jsp";
		
		String id=request.getParameter("id");
		
		try {
			request.setAttribute("vinili", vm.findByKey(id));
			redirectedPage = "/DettagliVinile.jsp";
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
