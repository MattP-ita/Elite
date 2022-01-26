package elite.control.IndirizzoControl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Cliente;
import elite.bean.Indirizzo;
import elite.model.IndirizzoModel;

@WebServlet("/cliente/VisualizzazioneIndirizziControl")
public class VisualizzazioneIndirizziControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisualizzazioneIndirizziControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		IndirizzoModel im = new IndirizzoModel();
		String redirectedPage = "/cliente/AreaPersonaleIndirizzi.jsp";
		Cliente c=(Cliente) request.getSession().getAttribute("Cliente");
		
		try {
			ArrayList<Indirizzo> i=im.findByClient(String.valueOf(c.getId()));
			if(i!=null) {
				request.setAttribute("indirizzi", i);
				redirectedPage = "/cliente/AreaPersonaleIndirizzi.jsp";
			}else throw new Exception("VisualizzazioneIndirizziControl: Indirizzi NULL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(redirectedPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
