package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supcrowdfunding.entity.User;
import com.supinfo.supcrowdfunding.entity.UserDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String pseudo = req.getParameter("pseudo");
		String password = User.passwordToMd5(req.getParameter("password"));
		HttpSession session = req.getSession();
	
		User user = UserDao.findUserByPseudo(pseudo);

		if( (user == null) || (pseudo == null ) || (password == null) || !(user.getPassword().equals(password) )) {
			req.setAttribute("errorLogin", true);
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		} else {
			
			session.setAttribute("id", user.getId());
			session.setAttribute("role", user.getRole());
			session.setAttribute("username", pseudo);
			resp.sendRedirect(req.getContextPath() + "/listProject");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}
}
