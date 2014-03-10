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
 * Servlet implementation class RemoveUserServlet
 */
@WebServlet(urlPatterns = "/auth/admin/removeUser")
public class RemoveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		RequestDispatcher rd = null;
    	

		try {
			UserDao.removeUser(id);
			req.setAttribute("alert", 1);
		} catch (NumberFormatException e) {
			req.setAttribute("alert", 0);
		}	
			rd = req.getRequestDispatcher("/auth/admin/usersManagement");
			rd.forward(req, resp);
		
	}

}
