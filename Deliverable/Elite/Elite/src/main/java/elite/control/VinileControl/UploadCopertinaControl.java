package elite.control.VinileControl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import elite.model.VinileModel;

@WebServlet("/gestore/UploadCopertinaControl")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadCopertinaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadCopertinaControl() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		out.write("Error: GET method is used but POST method is required");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("vinili");
		request.removeAttribute("msgFile");
		String browser = request.getHeader("User-Agent");
		String SAVE_DIR = "uploadTemp";
		String codice = request.getParameter("codiceV");
		String redirectedPage = "/gestore/Magazzino.jsp";
		
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + SAVE_DIR;

		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part, browser);
			if (fileName != null && !fileName.equals("")) {
				part.write(savePath + File.separator + fileName);
				try {
					VinileModel.updateCopertina(codice, savePath + File.separator + fileName);
				} catch (SQLException sqlException) {
					System.out.println(sqlException);
				}
			}
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	private String extractFileName(Part part, String browser) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		if ((browser.indexOf("Chrome") >= 0) || browser.indexOf("Safari") >= 0 || browser.indexOf("Firefox") >= 0) {
			for (String s : items) {
				if (s.trim().startsWith("filename")) {
					return s.substring(s.lastIndexOf("=") + 2, s.length() - 1);
				}
			}
		} else {
			for (String s : items) {
				if (s.trim().startsWith("filename")) {
					return s.substring(s.lastIndexOf("\\") + 1, s.length() - 1);
				}
			}
		}
		return "";
	}
}
