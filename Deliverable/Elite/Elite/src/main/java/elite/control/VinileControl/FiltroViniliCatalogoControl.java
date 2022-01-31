package elite.control.VinileControl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.model.ArtistaModel;
import elite.model.GenereModel;
import elite.model.VinileModel;

@WebServlet("/FiltroViniliCatalogoControl")
public class FiltroViniliCatalogoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public FiltroViniliCatalogoControl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		VinileModel vm=new VinileModel();
		GenereModel gm = new GenereModel();
		ArtistaModel am = new ArtistaModel();
		
		String redirectedPage = "/Catalogo.jsp";
		String action = request.getParameter("action");
		
		try {
			if (action != null) {
				if(action.equals("ricercaNome")) {
					request.getSession().removeAttribute("nomeRA");
					request.getSession().setAttribute("nomeRA", request.getParameter("nome"));
				}else if(action.equals("ricercaArtista")) {
					request.getSession().removeAttribute("artistaRA");
					request.getSession().setAttribute("artistaRA", request.getParameter("artista"));
				}else if(action.equals("ricercaGenere")) {
					request.getSession().removeAttribute("genereRA");
					request.getSession().setAttribute("genereRA", request.getParameter("genere"));
				}else if(action.equals("ricercaGiri")) {
					request.getSession().removeAttribute("giriRA");
					request.getSession().setAttribute("giriRA", request.getParameter("giri"));
				}else if(action.equals("ricercaPrezzo")) {	
					request.getSession().removeAttribute("prezzoMaxRA");	
					request.getSession().setAttribute("prezzoMaxRA", request.getParameter("rangeInputPrice"));
				}else if(action.equals("ricercaQuantita")) {
					if(request.getParameter("sceltaQuantita")!=null && !request.getParameter("sceltaQuantita").equals("")) {
						request.getSession().removeAttribute("sceltaQuantitaRA");
						request.getSession().removeAttribute("quantitaRA");
						request.getSession().setAttribute("quantitaRA", request.getParameter("rangeInputQuantity"));
						request.getSession().setAttribute("sceltaQuantitaRA", request.getParameter("sceltaQuantita"));
					}
				}else if(action.equals("ricercaSituazione")) {
					request.getSession().removeAttribute("situazioneRA");
					request.getSession().setAttribute("situazioneRA", request.getParameter("situazione"));
				}else if(action.equals("sort")) {
					request.getSession().removeAttribute("sortRA");
					request.getSession().setAttribute("sortRA", request.getParameter("sort"));
				}else if(action.equals("reset")) {
					request.getSession().removeAttribute("nomeRA");
					request.getSession().removeAttribute("artistaRA");
					request.getSession().removeAttribute("genereRA");
					request.getSession().removeAttribute("giriRA");
					request.getSession().removeAttribute("prezzoMinRA");	
					request.getSession().removeAttribute("prezzoMaxRA");	
					request.getSession().removeAttribute("sceltaQuantitaRA");
					request.getSession().removeAttribute("quantitaRA");
					request.getSession().removeAttribute("situazioneRA");
					request.getSession().removeAttribute("sortRA");
				}
			}
			String nome=(String)request.getSession().getAttribute("nomeRA");
			String artista=(String)request.getSession().getAttribute("artistaRA");
			String genere=(String)request.getSession().getAttribute("genereRA");
			String giri=(String)request.getSession().getAttribute("giriRA");
			String prezzoMax=(String)request.getSession().getAttribute("prezzoMaxRA");
			String quantita=(String)request.getSession().getAttribute("quantitaRA");
			String sceltaQuantita=(String)request.getSession().getAttribute("sceltaQuantitaRA");
			String sort=(String)request.getSession().getAttribute("sortRA");
			
			try {
				request.setAttribute("vinili", vm.advancedSearch(nome, artista, genere, giri, prezzoMax, quantita, sceltaQuantita, sort));
				request.setAttribute("artisti", am.findAll(""));
				request.setAttribute("generi",gm.findAll(""));
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (NumberFormatException e) {
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
