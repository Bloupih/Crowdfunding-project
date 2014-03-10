package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.Project;
import com.supinfo.supcrowdfunding.entity.ProjectDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/showProject")
public class ShowProjectServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String idParam = req.getParameter("id");

		int id;

		try {
			id = Integer.valueOf(idParam);
		} catch (NumberFormatException e) {
			resp.sendRedirect(req.getContextPath() + "/listProject");
			return;
		}

		Project project = ProjectDao.findProjectById(id);

		if (null == project) {
			resp.sendRedirect(req.getContextPath() + "/listProject");
			return;
		}

		req.setAttribute("project", project);
		RequestDispatcher rd = req.getRequestDispatcher("/showProject.jsp");
		rd.forward(req, resp);
	}

	@Override
	public void destroy() {}
}
