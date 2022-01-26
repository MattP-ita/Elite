package elite.control.ArtistaControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Artista;
import elite.model.ArtistaModel;
import elite.utils.Validator;

@WebServlet("/gestore/ModificaArtistaControl")
public class ModificaArtistaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaArtistaControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		ArtistaModel am = new ArtistaModel();
		String redirectedPage = "/gestore/Magazzino.jsp";

		String id = request.getParameter("idArtista");
		String nome = request.getParameter("nomeA");

		try {
			if (!nome.equals("") && !id.equals("")) {
				if (am.checkName(nome)) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {
						Artista a = new Artista(Integer.parseInt(id), nome);
						am.update(a);
					} else {
						request.setAttribute("msgErrorArtista", "Nome inserito non valido.");
						throw new Exception("ModificaArtistaControl: Errore Dati Non Validi");
					}
				} else {
					request.setAttribute("msgErrorArtista", "Nome già eistente.");
					throw new Exception("ModificaArtistaControl: Errore Numero Esistente");
				}
			} else {
				request.setAttribute("msgErrorArtista", "Nome Non Inserito");
				throw new Exception("ModificaArtistaControl: Dati Non Inseriti");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
