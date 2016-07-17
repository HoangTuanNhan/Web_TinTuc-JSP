package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelCategory;
import bean.Category;

/**
 * Servlet implementation class ControllerAdminEditCat
 */

public class ControllerAdminEditCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminEditCat() {
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
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		
		if(request.getParameter("sua")!=null){
			String username= new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
			Category objCat=new Category(cid,username);
			int result=modelCat.editItemCat(objCat);
			if(result>0){
				response.sendRedirect(request.getContextPath()+"/admin/indexCat?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editCat?msg=0");

			}
		}else{
			Category objCat=modelCat.getListByItem(cid);
			request.setAttribute("alCat", objCat);
			RequestDispatcher rd=request.getRequestDispatcher("/admin/editCat.jsp");
			rd.forward(request, response);
		}
	}

}
