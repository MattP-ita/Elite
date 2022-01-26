package elite.control.UtenteControl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Gestore;
import elite.model.GestoreModel;


@WebServlet("/admin/EliminazioneGestoreControl")
public class EliminazioneGestoreControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminazioneGestoreControl() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestoreModel gm = new GestoreModel();
		String id = request.getParameter("id");		
		String redirectedPage = "/admin/HomePageAdmin.jsp";
		
		try {
			Gestore g=gm.findByKey(id);
			if(!g.isEmpty()) {			
				gm.delete(g);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
