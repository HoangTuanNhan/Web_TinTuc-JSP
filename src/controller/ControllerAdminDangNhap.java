package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.LibraryString;
import model.ModelUsers;
import bean.Users;


/**
 * Servlet implementation class ControllerAdminDangNhap
 */

public class ControllerAdminDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDangNhap() {
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
		if (request.getParameter("login") != null) {
			ModelUsers mUser = new ModelUsers();
			LibraryString lc = new LibraryString();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String pass_new = lc.md5(password);
			Users objSUser = mUser.checkLogin(username, pass_new);
			if (objSUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("objSUser", objSUser);
				response.sendRedirect(request.getContextPath() + "/index");
//				RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
//				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/login?msg=0");
			}

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			rd.forward(request, response);
		}
	}

}
