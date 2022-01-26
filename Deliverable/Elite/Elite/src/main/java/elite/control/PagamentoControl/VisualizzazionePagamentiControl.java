package elite.control.PagamentoControl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Cliente;
import elite.bean.Pagamento;
import elite.model.PagamentoModel;

@WebServlet("/cliente/VisualizzazionePagamentiControl")
public class VisualizzazionePagamentiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzazionePagamentiControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PagamentoModel pm = new PagamentoModel();
		Cliente c=(Cliente) request.getSession().getAttribute("Cliente");
		String redirectedPage = "/cliente/AreaPersonalePagamenti.jsp";
		
		try {
			ArrayList<Pagamento> p=pm.findByClient(String.valueOf(c.getId()));
			if(p!=null) {
				request.setAttribute("pagamenti", p);
			}else throw new Exception("VisualizzazionePagamentiControl: Pagamenti NULL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(redirectedPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
