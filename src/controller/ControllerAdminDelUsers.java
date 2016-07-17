package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ModelUsers;
import bean.Users;

/**
 * Servlet implementation class ControllerAdminDelUsers
 */

public class ControllerAdminDelUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDelUsers() {
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
		
		ModelUsers modelUser=new ModelUsers();
		HttpSession session=request.getSession();
		Users objSUser=(Users)session.getAttribute("objSUser");
			
		if(session.getAttribute("objSUser")!=null){
			if(objSUser.getUsername().equals("admin")){
				int uid=Integer.parseInt(request.getParameter("uid"));
				int result=modelUser.delItemUsers(uid);
				if(result>0){
					response.sendRedirect(request.getContextPath()+("/admin/indexUsers?msg=1"));
				}else{
					response.sendRedirect(request.getContextPath()+("/admin/indexUsers?msg=0"));
				}
			}else{
				response.sendRedirect(request.getContextPath()+("/admin/indexUsers?err=0"));
			}
		}else{
			response.sendRedirect(request.getContextPath()+("/admin/login?msg=1"));

		}
	}

}
