package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelNews;

/**
 * Servlet implementation class ControllerAdminDelNews
 */

public class ControllerAdminDelNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDelNews() {
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
		ModelNews modelNews=new ModelNews();
		int nid=Integer.parseInt(request.getParameter("nid"));
		int result=modelNews.delItemNews(nid);
		
		if(result>0){
			response.sendRedirect(request.getContextPath()+"/admin/indexNews?msg=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/indexNews?msg=0");

		}
	}

}
