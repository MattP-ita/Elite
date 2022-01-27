package elite.control.CarrelloControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Carrello;
import elite.bean.Vinile;
import elite.model.VinileModel;
import elite.utils.Validator;


@WebServlet("/cliente/AggiuntaVinileCarrelloControl")
public class AggiuntaVinileCarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AggiuntaVinileCarrelloControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		
		VinileModel vm=new VinileModel();
		String redirectedPage = "/DettagliVinile.jsp";
		
		String id= request.getParameter("codiceV");
		String quantita=request.getParameter("quantita");
		
		try {
			if (!id.equals("")) {
				Validator validator = new Validator();
				if(validator.validaRequest(request)){
					Vinile v= vm.findByKey(id);
					if(v!=null) {
						v.setQuantita(Integer.parseInt(quantita));
						carrello.addItem(v);
					}else {
						request.setAttribute("msgError", "id non valido.");
						throw new Exception("AggiuntaVinileCarrelloControl: Errore Dati Non Validi");
					}
				}else {
					request.setAttribute("msgError", "id non valido.");
					throw new Exception("AggiuntaVinileCarrelloControl: Errore Dati Non Validi");
				}
			}else throw new Exception("AggiuntaVinileCarrelloControl: id null");			
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
