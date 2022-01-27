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


@WebServlet("/cliente/EliminazioneVinileCarrelloControl")
public class EliminazioneVinileCarrelloControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EliminazioneVinileCarrelloControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		VinileModel vm=new VinileModel();
		String redirectedPage = "/CarrelloCliente.jsp";
		
		String id= request.getParameter("codiceV");
		
		try {
			if (!id.equals("")) {
				Validator validator = new Validator();
				if(validator.valida(id, "codiceV")){
					Vinile v= vm.findByKey(id);
					if(v!=null) {
						carrello.deleteItem(v);
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
