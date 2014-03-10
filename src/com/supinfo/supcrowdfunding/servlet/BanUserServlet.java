package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.UserDao;

/**
 * Servlet implementation class banUser
 */
@WebServlet("/auth/admin/banUser")
public class BanUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String idParam = req.getParameter("id");
		RequestDispatcher rd = null;
		int id = Integer.valueOf(idParam);
		String newrole ="";
		int actualrole = UserDao.findUserById(id).getRole();
		if( actualrole == 1)
		{
			newrole = "banned";
		}
		else if (actualrole == 2)
		{
			newrole = "user";	
		}
		else if (actualrole == 0)
		{
			newrole = "admin";
		}
		UserDao.updateRole(id, newrole);
    	 rd = req.getRequestDispatcher("/auth/admin/usersManagement");
		rd.forward(req, resp);
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	}

}
