package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryPermission;
import model.ModelCategory;
import bean.Category;

/**
 * Servlet implementation class ControllerAdminAddCat
 */

public class ControllerAdminAddCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAddCat() {
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
		ModelCategory modelCat=new ModelCategory();
		LibraryPermission lPer = new LibraryPermission();
		if (lPer.isLogin(request, response)) {
			return;
		}
		if(request.getParameter("them")!=null){
			String username= new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
			Category objCat=new Category(0, username); 
			int result=modelCat.addItemCat(objCat);
			if(result>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=1");
				
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/addCat?msg=0");
			}
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("/admin/addCat.jsp");
			rd.forward(request, response);
		}
	}

}
