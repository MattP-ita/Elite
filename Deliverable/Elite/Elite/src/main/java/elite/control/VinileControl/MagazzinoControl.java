package elite.control.VinileControl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Artista;
import elite.bean.Genere;
import elite.bean.Vinile;
import elite.model.ArtistaModel;
import elite.model.GenereModel;
import elite.model.VinileModel;


@WebServlet("/gestore/MagazzinoControl")
public class MagazzinoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MagazzinoControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		VinileModel vm = new VinileModel();
		ArtistaModel am = new ArtistaModel();
		GenereModel gm = new GenereModel();
		
		String redirectedPage = "/gestore/Magazzino.jsp";
		
		try {
			ArrayList<Vinile> v=vm.findAll("");
			ArrayList<Artista> a=am.findAll("");
			ArrayList<Genere> g=gm.findAll("");
			
			request.setAttribute("vinili", v);
			request.setAttribute("artisti", a);
			request.setAttribute("generi", g);
			redirectedPage = "/gestore/Magazzino.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(redirectedPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
