package elite.control.VinileControl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Vinile;
import elite.model.VinileModel;
import elite.utils.Validator;

@WebServlet("/gestore/AggiuntaVinileControl")
public class AggiuntaVinileControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AggiuntaVinileControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		VinileModel vm = new VinileModel();
		String redirectedPage = "/gestore/Magazzino.jsp";

		String codice = request.getParameter("codiceV");
		String nome = request.getParameter("nomeV");
		String giri = request.getParameter("giri");
		String artista = request.getParameter("idArtista");
		String genere = request.getParameter("idGenere");
		String prezzo = request.getParameter("prezzo");
		String quantita = request.getParameter("quantita");

		try {
			if (!codice.equals("") && !nome.equals("") && !giri.equals("") && !artista.equals("") && !genere.equals("") && !prezzo.equals("")
					&& !quantita.equals("")) {
				if (vm.checkCode(codice)) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {						
						Vinile v = new Vinile(codice, nome, giri, Integer.parseInt(artista), Integer.parseInt(genere), Double.parseDouble(prezzo), Integer.parseInt(quantita));
						vm.save(v);
					} else {
						request.setAttribute("msgError", "Dati inseriti non validi.");
						throw new Exception("AggiuntaVinileControl: Errore Dati Non Validi");
					}
				} else {
					request.setAttribute("msgError", "Codice già eistente.");
					throw new Exception("AggiuntaVinileControl: Errore Email Esistente");
				}
			} else {
				request.setAttribute("msgError", "Dati Non Inseriti");
				throw new Exception("AggiuntaVinileControl: Dati Non Inseriti");
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
