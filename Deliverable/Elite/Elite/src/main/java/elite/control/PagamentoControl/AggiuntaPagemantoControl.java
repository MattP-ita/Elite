package elite.control.PagamentoControl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Cliente;
import elite.bean.Pagamento;
import elite.model.PagamentoModel;
import elite.utils.Validator;

@WebServlet("/cliente/AggiuntaPagamentoControl")
public class AggiuntaPagemantoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AggiuntaPagemantoControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PagamentoModel pm = new PagamentoModel();
		String redirectedPage = request.getHeader("Referer").substring(
				request.getHeader("Referer").indexOf(request.getContextPath()) + request.getContextPath().length());
		String tipo = request.getParameter("tipo");
		String nome = request.getParameter("nomeCompleto");
		String numero = request.getParameter("numero");
		String meseP = request.getParameter("meseP");
		String annoP = request.getParameter("annoP");
		try {
			if (!tipo.equals("") && !nome.equals("") && !numero.equals("") && !meseP.equals("") && !annoP.equals("")) {
				if (pm.checkNumber(numero)) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {		
						System.out.println("dentro");
						Cliente c = (Cliente) request.getSession().getAttribute("Cliente");
						Pagamento p = new Pagamento(tipo, c.getId(), nome, numero, meseP + annoP);
						p.checkPagamento();
						if(p.isValid()) {
							pm.save(p);
						}else {
							request.setAttribute("msgError", "Dati inseriti non validi.");
							throw new Exception("AggiuntaPagementoControl: Errore Carta Non Valida");
						}
					} else {
						request.setAttribute("msgError", "Dati inseriti non validi.");
						throw new Exception("AggiuntaPagementoControl: Errore Dati Non Validi");
					}
				} else {
					request.setAttribute("msgErr)or", "Numero già eistente.");
					throw new Exception("AggiuntaPagementoControl: Errore Numero Esistente");
				}
			} else {
				request.setAttribute("msgError", "Dati Non Inseriti");
				throw new Exception("AggiuntaPagementoControl: Dati Non Inseriti");
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
