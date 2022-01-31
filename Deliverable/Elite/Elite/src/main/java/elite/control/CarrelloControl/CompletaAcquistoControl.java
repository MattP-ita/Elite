package elite.control.CarrelloControl;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Carrello;
import elite.bean.Cliente;
import elite.bean.Indirizzo;
import elite.bean.Ordine;
import elite.bean.Pagamento;
import elite.bean.Vinile;
import elite.model.IndirizzoModel;
import elite.model.OrdineModel;
import elite.model.PagamentoModel;

@WebServlet("/cliente/CompletaAcquistoControl")
public class CompletaAcquistoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompletaAcquistoControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		OrdineModel om=new OrdineModel();
		IndirizzoModel im=new IndirizzoModel();
		PagamentoModel pm=new PagamentoModel();
		String redirectedPage = "/cliente/CarrelloCliente.jsp";
	
		String idP=request.getParameter("idPagamento");
		String idI=request.getParameter("idIndirizzo");
		Carrello carrello=(Carrello) request.getSession().getAttribute("carrello");
		Cliente c=(Cliente) request.getSession().getAttribute("Cliente");
		
		try {
			Indirizzo i=im.findByKey(idI);
			Pagamento p=pm.findByKey(idP);
			LocalDate data = LocalDate.now();
			Ordine o=new Ordine(c.getId(), i, p, data);
			o.generateId();
			om.save(o);
			for(Vinile v:carrello.getItems()) {
				om.insertContenutoOrdine(o, v);
			}
			carrello.deleteItems();
			redirectedPage = "/HomePageCliente.jsp";
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
