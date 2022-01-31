package elite.control.IndirizzoControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Cliente;
import elite.bean.Indirizzo;
import elite.model.IndirizzoModel;
import elite.utils.Validator;

@WebServlet("/cliente/AggiuntaIndirizzoControl")
public class AggiuntaIndirizzoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AggiuntaIndirizzoControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		IndirizzoModel im = new IndirizzoModel();
		String redirectedPage = request.getHeader("Referer").substring(
				request.getHeader("Referer").indexOf(request.getContextPath()) + request.getContextPath().length());

		String nome = request.getParameter("nomeCompleto");
		String telefono = request.getParameter("telefono");
		String indirizzo = request.getParameter("indirizzo");
		String regione = request.getParameter("regione");
		String provincia = request.getParameter("provincia");
		String citta = request.getParameter("citta");
		String cap = request.getParameter("cap");
		String descrizione = request.getParameter("descrizione");

		try {
			if (!nome.equals("") && !telefono.equals("") && !indirizzo.equals("") && !regione.equals("")
					&& !provincia.equals("") && !citta.equals("") && !cap.equals("")) {
				Validator validator = new Validator();
				if (validator.validaRequest(request)) {
					Cliente c = (Cliente) request.getSession().getAttribute("Cliente");
					Indirizzo i = new Indirizzo(c.getId(), nome, telefono, indirizzo, regione, provincia, citta, cap,
							descrizione);
					im.save(i);
				} else {
					request.setAttribute("msgError", "Dati inseriti non validi.");
					throw new Exception("AggiuntaIndirizzoControl: Errore Dati Non Validi");
				}
			} else {
				request.setAttribute("msgError", "Dati Non Inseriti");
				throw new Exception("AggiuntaIndirizzoControl: Dati Non Inseriti");
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
