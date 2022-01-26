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

@WebServlet("/cliente/AggiuntaPagementoControl")
public class AggiuntaPagementoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AggiuntaPagementoControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PagamentoModel pm = new PagamentoModel();
		String redirectedPage = "/cliente/AreaPersonalePagamenti.jsp";

		String tipo = request.getParameter("tipo");
		String nome = request.getParameter("nomeCompleto");
		String numero = request.getParameter("numero");
		String meseP = request.getParameter("meseP");
		String annoP = request.getParameter("annoP");
		String codice = request.getParameter("codice");

		try {
			if (!tipo.equals("") && !nome.equals("") && !numero.equals("") && !meseP.equals("") && !annoP.equals("")
					&& !codice.equals("")) {
				if (pm.checkNumber(numero)) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {
						// if(validaCarta(numero, codice)){
						Cliente c=(Cliente) request.getSession().getAttribute("Cliente");
						Pagamento p = new Pagamento(tipo, c.getId(), nome, numero, meseP+annoP, codice);
						pm.save(p);
						// }else {
						//request.setAttribute("msgError", "Metodo di Pagamento non valido");
						//throw new Exception("AggiuntaPagementoControl: Metodo Pagamento Non Valido");
						//}
					}else {
						request.setAttribute("msgError", "Dati inseriti non validi.");
						throw new Exception("AggiuntaPagementoControl: Errore Dati Non Validi");
					}
				}else {
					request.setAttribute("msgError", "Numero già eistente.");
					throw new Exception("AggiuntaPagementoControl: Errore Numero Esistente");
				}
			}else {
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
