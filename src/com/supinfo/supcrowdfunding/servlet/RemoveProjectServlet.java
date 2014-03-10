package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.ProjectDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/admin/removeProject")
public class RemoveProjectServlet extends HttpServlet {


	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding("UTF-8");
		String idParam = req.getParameter("id");
		RequestDispatcher rd = null;
		int id;

		try {
			id = Integer.valueOf(idParam);
			ProjectDao.removeProject(id);
			req.setAttribute("alert", 1);
		} catch (NumberFormatException e) {
			req.setAttribute("alert", 0);
		}	
		rd = req.getRequestDispatcher("/auth/admin/projectsManagement");
		rd.forward(req, resp);
			
	}

	@Override
	public void destroy() {
	}

}
