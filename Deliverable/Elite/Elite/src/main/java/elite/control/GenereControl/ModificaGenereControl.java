package elite.control.GenereControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Genere;
import elite.model.GenereModel;
import elite.utils.Validator;


@WebServlet("/gestore/ModificaGenereControl")
public class ModificaGenereControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ModificaGenereControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		GenereModel gm = new GenereModel();
		String redirectedPage = "/gestore/Magazzino.jsp";

		String id = request.getParameter("idGenere");
		String nome = request.getParameter("nomeG");

		try {
			if (!nome.equals("") && !id.equals("")) {
				if (gm.checkName(nome)) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {
						Genere g = new Genere(Integer.parseInt(id), nome);
						gm.update(g);
					} else {
						request.setAttribute("msgErrorGenere", "Nome inserito non valido.");
						throw new Exception("ModificaGenereControl: Errore Dati Non Validi");
					}
				} else {
					request.setAttribute("msgErrorGenere", "Nome già eistente.");
					throw new Exception("ModificaGenereControl: Errore Nome Esistente");
				}
			} else {
				request.setAttribute("msgErrorGenere", "Nome Non Inserito");
				throw new Exception("ModificaGenereControl: Dati Non Inseriti");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
