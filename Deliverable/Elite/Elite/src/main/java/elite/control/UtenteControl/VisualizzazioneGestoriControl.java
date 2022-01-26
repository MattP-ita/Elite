package elite.control.UtenteControl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Gestore;
import elite.model.GestoreModel;

@WebServlet("/admin/VisualizzazioneGestoriControl")
public class VisualizzazioneGestoriControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzazioneGestoriControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		GestoreModel gm = new GestoreModel();
		String redirectedPage = "/admin/HomePageAdmin.jsp";
		
		try {
			ArrayList<Gestore> g=gm.findAll("");
			request.setAttribute("gestori", g);
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
