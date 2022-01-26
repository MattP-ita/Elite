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

@WebServlet("/gestore/ModificaVinileControl")
public class ModificaVinileControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaVinileControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		VinileModel vm = new VinileModel();
		String redirectedPage = "/gestore/Magazzino.jsp";

		String codice = request.getParameter("id");
		String nome = request.getParameter("nomeV");
		String giri = request.getParameter("giri");
		String artista = request.getParameter("idArtista");
		String genere = request.getParameter("idGenere");
		String prezzo = request.getParameter("prezzo");
		String quantita = request.getParameter("quantita");

		try {
			if (!nome.equals("") || !giri.equals("") || !artista.equals("") || !genere.equals("") || !prezzo.equals("")
					|| !quantita.equals("")) {
				Validator validator = new Validator();
				Vinile v = vm.findByKey(codice);

				if (!nome.equals("")) {
					if (validator.valida(nome, "nomeV")) {
						v.setNome(nome);
					} else {
						request.setAttribute("msgErrorNomeVinile", "Nome non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				if (!giri.equals("")) {
					if (validator.valida(giri, "giri")) {
						v.setGiri(giri);
					} else {
						request.setAttribute("msgErrorGiriVinile", "Giri non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				if (!artista.equals("")) {					
					v.setIdArtista(Integer.parseInt(artista));					
				}
				if (!genere.equals("")) {
					v.setIdGenere(Integer.parseInt(genere));	
				}
				if (!prezzo.equals("")) {
					if (validator.valida(prezzo, "prezzo")) {
						v.setPrezzo(Double.parseDouble(prezzo));
					} else {
						request.setAttribute("msgErrorPrezzoVinile", "Prezzo non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				if (!quantita.equals("")) {
					if (validator.valida(quantita, "quantita")) {
						v.setQuantita(Integer.parseInt(quantita));
					} else {
						request.setAttribute("msgErrorQuantitaVinile", "Quantità non valida");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				vm.update(v);
			} else {
				request.setAttribute("msgError", "Nassun Dato inserito");
				throw new Exception("ModificaVinileControl: Dati Non Inseriti");
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
