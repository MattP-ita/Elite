package elite.control.IndirizzoControl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Indirizzo;
import elite.model.IndirizzoModel;

@WebServlet("/cliente/EliminazioneIndirizzoControl")
public class EliminazioneIndirizzoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminazioneIndirizzoControl() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IndirizzoModel im = new IndirizzoModel();
		String id = request.getParameter("id");		
		String redirectedPage = "/cliente/AreaPersonaleIndirizzi.jsp";
		
		try {
			Indirizzo i=im.findByKey(id);
			im.delete(i);			
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
