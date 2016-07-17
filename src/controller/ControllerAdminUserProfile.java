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
 * Servlet implementation class ControllerAdminUserProfile
 */

public class ControllerAdminUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAdminUserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		ModelUsers mUser = new ModelUsers();

		HttpSession session = request.getSession();
		Users objSUser = (Users) session.getAttribute("objSUser");

		

		if (session.getAttribute("objSUser") != null) {
			if ("admin".equals(objSUser.getUsername())) {
				response.sendRedirect(request.getContextPath()
						+ "/admin/indexUsers?msg=1");

			} else {
				if (request.getParameter("sua")!=null) {
					String password_new = "";
					String ten = request.getParameter("ten");
					String password = request.getParameter("password");
					String fullname = request.getParameter(
							"fullname");
					if ("".equals(password)) {
						Users objUser = mUser.getListByItem(objSUser
								.getIdUsers());
						password_new = objUser.getPassword();
					} else {
						LibraryString lString = new LibraryString();
						password_new = lString.md5(password);
					}
					Users objUser = new Users(objSUser.getIdUsers(), ten,
							password_new, fullname);
					session.removeAttribute("objSUser");
					session.setAttribute("objSUser", objUser);
					int result = mUser.editItem(objUser);
					if (result > 0) {
						response.sendRedirect(request.getContextPath()
								+ "/admin/indexUsers?msg=1");
					} else {
						response.sendRedirect(request.getContextPath()
								+ "/admin/editUsers?msg=0");
					}
				} else {

					RequestDispatcher rd = request
							.getRequestDispatcher("/admin/profile.jsp");
					rd.forward(request, response);
				}
			}

		} else {
			response.sendRedirect(request.getContextPath()
					+ "/admin/login?msg=1");
		}
	}

}
