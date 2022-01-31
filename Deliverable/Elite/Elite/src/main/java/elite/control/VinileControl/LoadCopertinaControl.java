package elite.control.VinileControl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elite.model.VinileModel;


@WebServlet("/LoadCopertinaControl")
public class LoadCopertinaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoadCopertinaControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("codiceV");
		try {
			if (id != null){
				byte[] bt=null;
				bt = VinileModel.loadCopertina(id);
				
				ServletOutputStream out = response.getOutputStream();
				if(bt != null){
					out.write(bt);
					response.setContentType("image/jpeg");			
				}
				out.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
