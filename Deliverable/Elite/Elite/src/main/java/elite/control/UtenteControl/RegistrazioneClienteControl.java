package elite.control.UtenteControl;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Cliente;
import elite.model.ClienteModel;
import elite.utils.Validator;

@WebServlet("/RegistrazioneClienteControl")
public class RegistrazioneClienteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrazioneClienteControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		ClienteModel cm = new ClienteModel();
		String redirectedPage = "/HomePageCliente.jsp";

		String nome = request.getParameter("nome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		try {
			if (!nome.equals("") && !telefono.equals("") && !email.equals("") && !password.equals("")) {
				if (cm.checkEmail(email)) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {
						if (password.equals(password2)) {
							Cliente cliente = new Cliente(nome, telefono, email, Base64.getEncoder().encodeToString(password.getBytes()));
							cm.save(cliente);
							redirectedPage = "/HomePageCliente.jsp";
						} else {
							request.setAttribute("msgError", "Password Diverse.");
							throw new Exception("RegistazioneClienteControl: Errore Password Diverse");
						}
					} else {
						request.setAttribute("msgError", "Dati inseriti non validi.");
						throw new Exception("RegistazioneClienteControl: Errore Dati Non Validi");
					}
				} else {
					request.setAttribute("msgError", "Email già eistente.");
					throw new Exception("RegistazioneClienteControl: Errore Email Esistente");
				}
			}else {
				request.setAttribute("msgError", "Dati Non Inseriti");
				throw new Exception("RegistazioneClienteControl: Dati Non Inseriti");
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
