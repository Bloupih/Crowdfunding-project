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
 * Servlet implementation class ShowProfilServlet
 */
@WebServlet(urlPatterns = "/auth/showProfile")
public class ShowProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	request.setCharacterEncoding("UTF-8");
		int id = (int)request.getSession().getAttribute("id");
		
		User user = UserDao.findUserById(id);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/auth/showprofile.jsp");
		rd.forward(request, response);
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
