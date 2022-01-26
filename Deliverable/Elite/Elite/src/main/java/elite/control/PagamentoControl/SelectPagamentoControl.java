package elite.control.PagamentoControl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.model.PagamentoModel;

@WebServlet("/cliente/SelectPagamentoControl")
public class SelectPagamentoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectPagamentoControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		request.getSession().removeAttribute("pagamento");
		
		PagamentoModel pm=new PagamentoModel();
		String redirectedPage = "/cliente/AreaPersonalePagamenti.jsp";
		
		String id=request.getParameter("id");
		
		try {
				request.getSession().setAttribute("pagamento", pm.findByKey(id));
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
