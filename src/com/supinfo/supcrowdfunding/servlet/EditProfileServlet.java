package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.User;
import com.supinfo.supcrowdfunding.entity.UserDao;

/**
 * Servlet implementation class EditProfileServlet
 */

@WebServlet(urlPatterns = { "/auth/editProfile","/auth/admin/userManagement/editProfile"})
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User usr = UserDao.findUserById((int) request.getSession().getAttribute("id"));
		request.setAttribute("user", usr);
		RequestDispatcher rd = request.getRequestDispatcher("/auth/editprofile.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		String update_nom = "";
		String update_prenom = "";
		String update_mail = "";
		String update_password = "";
		User usr ; 
		RequestDispatcher rd ;
		
		if(request.getParameter("nom") != null && !(request.getParameter("nom").equals("")) )
		{
			update_nom = request.getParameter("nom");
			update_prenom = request.getParameter("prenom");
			update_mail = request.getParameter("mail");
			update_password = request.getParameter("password");
			usr = UserDao.findUserById(id);
			usr.setName(update_nom);
			usr.setFirstname(update_prenom);
			usr.setMail(update_mail);
			if(update_password != "")
			{
				usr.setPassword(update_password);
			}
			UserDao.editUser(usr);
			rd = request.getRequestDispatcher("/auth/showProfile");
			
		}
		else
		{
			usr = UserDao.findUserById(id);
			request.setAttribute("user", usr);
			rd = request.getRequestDispatcher("/auth/editprofile.jsp");
		}
		
		rd.forward(request, response);
		
	}

}
