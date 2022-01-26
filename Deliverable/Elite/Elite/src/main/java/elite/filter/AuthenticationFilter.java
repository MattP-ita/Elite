package elite.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import elite.bean.Admin;
import elite.bean.Cliente;
import elite.bean.Gestore;

@WebFilter(urlPatterns = { "/admin/*", "/cliente/*", "/gestore/*" })
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		String uri = hrequest.getRequestURI();

		System.out.println(uri);

		if (uri.contains("/cliente/")) {
			HttpSession session = hrequest.getSession(false);
			if (session != null) {
				Cliente c = (Cliente) session.getAttribute("Cliente");
				String r = (String) session.getAttribute("accountRoles");

				if (c != null && r.equals("cliente")) {
					chain.doFilter(request, response);
				} else
					hresponse.sendRedirect(hrequest.getContextPath() + "/LoginCliente.jsp");
			} else
				hresponse.sendRedirect(hrequest.getContextPath() + "/LoginCliente.jsp");
		} else if (uri.contains("/admin/")) {
			HttpSession session = hrequest.getSession(false);
			if (session != null) {
				Admin a = (Admin) session.getAttribute("Admin");
				String r = (String) session.getAttribute("accountRoles");

				if (a != null && r.equals("admin")) {
					chain.doFilter(request, response);
				} else
					hresponse.sendRedirect(hrequest.getContextPath() + "/LoginAdmin.jsp");
			} else
				hresponse.sendRedirect(hrequest.getContextPath() + "/LoginAdmin.jsp");
		} else if (uri.contains("/gestore/")) {
			HttpSession session = hrequest.getSession(false);
			if (session != null) {
				Gestore g = (Gestore) session.getAttribute("Gestore");
				String r = (String) session.getAttribute("accountRoles");

				if (g != null && r.equals("gestore")) {
					chain.doFilter(request, response);
				} else
					hresponse.sendRedirect(hrequest.getContextPath() + "/LoginGestore.jsp");
			} else
				hresponse.sendRedirect(hrequest.getContextPath() + "/LoginGestore.jsp");
		} else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
