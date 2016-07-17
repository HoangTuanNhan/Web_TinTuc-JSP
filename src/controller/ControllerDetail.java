package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.News;
import model.ModelNews;

/**
 * Servlet implementation class ControllerDetail
 */

public class ControllerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDetail() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		News objNews=modelNews.getListDetail(id);
		request.setAttribute("objNews", objNews);
		ArrayList<News> alNews=modelNews.getListDetail(id,objNews.getIdCat());
		request.setAttribute("alNews",alNews);
		RequestDispatcher rd=request.getRequestDispatcher("/chitiet.jsp");
		rd.forward(request, response);
	}

}
