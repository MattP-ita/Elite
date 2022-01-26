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

@WebServlet("/cliente/ModificaDatiClienteControl")
public class ModificaDatiClienteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaDatiClienteControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		ClienteModel cm = new ClienteModel();
		String redirectedPage = "/cliente/AreaPersonale.jsp";

		String nome = request.getParameter("nome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			if (!nome.equals("") || !telefono.equals("") || !email.equals("") || !password.equals("")) {
				Validator validator = new Validator();
				Cliente c = (Cliente) request.getSession().getAttribute("Cliente");

				if (!nome.equals("")) {
					if (validator.valida(nome, "nome")) {
						c.setNome(nome);
					} else {
						request.setAttribute("msgErrorNome", "Nome non valido");
						throw new Exception("ModificaDatiClienteControl: Dati Non Validi");
					}
				}
				if (!telefono.equals("")) {
					if (validator.valida(telefono, "telefono")) {
						c.setTelefono(telefono);
					} else {
						request.setAttribute("msgErrorTelefono", "Telefono non valido");
						throw new Exception("ModificaDatiClienteControl: Dati Non Validi");
					}
				}
				if (!email.equals("")) {
					if (validator.valida(email, "email")) {
						if (cm.checkEmail(email)) {
							c.setEmail(email);
						}
					} else {
						request.setAttribute("msgErrorEmail", "E-mail non valida");
						throw new Exception("ModificaDatiClienteControl: Dati Non Validi");
					}
				}
				if (!password.equals("")) {
					if (validator.valida(password, "password")) {
						c.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));
					} else {
						request.setAttribute("msgErrorPassword", "Password non valida");
						throw new Exception("ModificaDatiClienteControl: Dati Non Validi");
					}
				}
				cm.update(c);
			} else {
				request.setAttribute("msgError", "Nassun Dato inserito");
				throw new Exception("ModificaDatiClienteControl: Dati Non Inseriti");
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
