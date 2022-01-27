package elite.control.UtenteControl;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Carrello;
import elite.bean.Cliente;
import elite.model.ClienteModel;

@WebServlet("/LoginClienteControl")
public class LoginClienteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginClienteControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		request.getSession().removeAttribute("Cliente");
		request.getSession().removeAttribute("Admin");
		request.getSession().removeAttribute("Gestore");
		request.getSession().invalidate();
		
		ClienteModel cm = new ClienteModel();
		String redirectedPage = "/LoginCliente.jsp";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			if(!email.equals("") || !password.equals("")) {
				Cliente c=cm.checkAccount(email, Base64.getEncoder().encodeToString(password.getBytes()));
				if(!c.isEmpty()) {
					request.getSession().setAttribute("Cliente", c);
					request.getSession().setAttribute("accountRoles", "cliente");
					redirectedPage = "/HomePageCliente.jsp";
					Carrello carrello = new Carrello();
					request.getSession().setAttribute("carrello", carrello);
				}else{
					request.setAttribute("msgError", "Login errato, riprova.");
					throw new Exception("LoginClienteControl: Account non trovato");
				}
			}else {
				request.setAttribute("msgError", "E-mail e/o password non inseriti.");
				throw new Exception("LoginClienteControl: Dati Non Inseriti");
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
