package elite.control.UtenteControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("accountRoles");
		request.getSession().removeAttribute("Cliente");
		request.getSession().removeAttribute("Gestore");
		request.getSession().removeAttribute("Admin");
		request.getSession().invalidate();
		
		String redirectedPage="/HomePageCliente.jsp";
		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath()+redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
