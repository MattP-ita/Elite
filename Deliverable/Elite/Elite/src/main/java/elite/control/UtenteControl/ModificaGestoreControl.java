package elite.control.UtenteControl;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Gestore;
import elite.model.GestoreModel;
import elite.utils.Validator;


@WebServlet("/admin/ModificaGestoreControl")
public class ModificaGestoreControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ModificaGestoreControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		GestoreModel gm = new GestoreModel();
		String redirectedPage = "/admin/HomePageAdmin.jsp";
		
		String id=request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		try {
			if (!nome.equals("") || !email.equals("") || !password.equals("")) {
				Validator validator = new Validator();
				Gestore g=gm.findByKey(id);
				if(g!=null) {				
					if(!nome.equals("")) {
						if(validator.valida(nome, "nome")) {
							g.setNome(nome);
						}else {
							request.setAttribute("msgError", "Nome non valido");
							throw new Exception("ModificaGestoreControl: Dati Non Validi");
						}
					}
					if(!email.equals("")) {
						if(validator.valida(email, "email")) {
							if(gm.checkEmail(email)) {
								g.setEmail(email);
							}
						}else {
							request.setAttribute("msgError", "E-mail non valida");
							throw new Exception("ModificaGestoreControl: Dati Non Validi");
						}
					}
					if(!password.equals("")) {
						if(validator.valida(password, "password")) {
							if(password.equals(password2)) {
								g.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));
							}else {
								request.setAttribute("msgError", "Le Password non coincidono");
								throw new Exception("ModificaGestoreControl: Dati Non Validi");
							}
						}else {
							request.setAttribute("msgError", "Password non valida");
							throw new Exception("ModificaGestoreControl: Dati Non Validi");
						}
					}				
					gm.update(g);
				}
			}else {
				request.setAttribute("msgError", "Nassun Dato inserito");
				throw new Exception("ModificaGestoreControl: Dati Non Inseriti");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
