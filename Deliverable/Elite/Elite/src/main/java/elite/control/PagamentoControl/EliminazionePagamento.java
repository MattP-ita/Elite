package elite.control.PagamentoControl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.bean.Pagamento;
import elite.model.PagamentoModel;

@WebServlet("/cliente/EliminazionePagamento")
public class EliminazionePagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminazionePagamento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PagamentoModel pm = new PagamentoModel();
		String id = request.getParameter("id");		
		String redirectedPage = "/cliente/AreaPersonalePagamenti.jsp";
		
		try {
			Pagamento p=pm.findByKey(id);	
			pm.delete(p);			
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
