package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.User;
import com.supinfo.supcrowdfunding.entity.UserDao;

/**
 * Servlet implementation class DashboardUserServlet
 */
@WebServlet(urlPatterns = "/auth/admin/usersManagement")
public class DashboardUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	req.setCharacterEncoding("UTF-8");
    	int totalCountUsers = UserDao.getCountUsers();
    	List<User> users = UserDao.getAllUsers();
    	RequestDispatcher rd = null;
    	
    	req.setAttribute("users", users);
    	req.setAttribute("totalCountUsers", totalCountUsers);
    	
    	rd = req.getRequestDispatcher("/auth/admin/dash-users.jsp");
		rd.forward(req, resp);
    	
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	}

}
