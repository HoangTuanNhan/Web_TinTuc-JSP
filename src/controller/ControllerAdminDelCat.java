package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryPermission;
import model.ModelCategory;

/**
 * Servlet implementation class ControllerAdminDelCat
 */

public class ControllerAdminDelCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDelCat() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int cid=Integer.parseInt(request.getParameter("cid"));
		ModelCategory modelCat=new ModelCategory();
		LibraryPermission lPer = new LibraryPermission();
		if (lPer.isLogin(request, response)) {
			return;
		}
		int result=modelCat.delItemCat(cid);
		
		if(result>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=0");
		}
		
	}

}
