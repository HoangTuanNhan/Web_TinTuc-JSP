package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelNews;

/**
 * Servlet implementation class ControllerNews
 */
public class ControllerNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerNews() {
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
		ModelNews modelNews=new ModelNews();
		int current_page=1;
		
		int row_count=5;//số dòng trên một trang
		//lấy tổng số dòng
		int sotrang=0;
		int total=modelNews.getTotal();
		//tinh số trang
		 sotrang=(int)Math.ceil((float)total/row_count);
		 request.setAttribute("sotrang",sotrang);
		 //lấy trang hiện tại
		 if(request.getParameter("page")!=null){
			  current_page=Integer.parseInt(request.getParameter("page"));

		}
		 request.setAttribute("current_page",current_page);
		 int offset=(current_page-1)*row_count;
		// request.setAttribute("alTinTuc",modelNews.getListNews());
		 request.setAttribute("alTinTuc", modelNews.getListForPaginator(offset, row_count));
		
	
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/tintuc.jsp");
		rd.forward(request, response);
	}

}
