package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryPermission;
import model.ModelCategory;
import model.ModelNews;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.News;

/**
 * Servlet implementation class ControllerAdminAddNews
 */

public class ControllerAdminAddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LibraryPermission lPer = new LibraryPermission();
		if (lPer.isLogin(request, response)) {
			return;
		}
		ModelCategory mc = new ModelCategory();
		request.setAttribute("alCat", mc.getListCat());
		String name = "";
		String preview_text = "";
		String detail_text = "";
		int id_cat = 0;
		String picture = "";
		if (!"load".equals(request.getParameter("type"))) {
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				try {
					List<FileItem> formItems = upload.parseRequest(request);
					for (FileItem fileItem : formItems) {
						if (fileItem.isFormField()) {
							String fieldname = fileItem.getFieldName();
							String fieldValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");
							switch (fieldname) {
							case "name":
								name = fieldValue;
								break;
							case "preview_text":
								preview_text = fieldValue;
								break;
							case "detail_text":
								detail_text = fieldValue;
								break;
							case "id_cat":
								id_cat = Integer.parseInt(fieldValue);
								break;
							default:
								break;
							}
						} else {
							picture = fileItem.getName();
							if (!picture.equals("")) {
								picture = FilenameUtils.getBaseName(picture) + "-" + System.nanoTime() + "."
										+ FilenameUtils.getExtension(picture);
								String pathname = request.getServletContext().getRealPath("") + File.separator + "files"
										+ File.separator + picture;
								File file = new File(pathname);
								fileItem.write(file);
							}
							else{
								picture = "noImage.jpg";
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ModelNews mn = new ModelNews();
				News news = new News(0, name, preview_text, detail_text, id_cat, picture,"");
				if (mn.addItem(news)) {
					response.sendRedirect(request.getContextPath() + "/admin/indexNews?msg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/addNews?msg=0");
				}
			} else {
				System.out.println("Form không thỏa mãn upload");
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addNews.jsp");
			rd.forward(request, response);
		}
	}

}
