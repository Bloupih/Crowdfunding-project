package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.Category;
import com.supinfo.supcrowdfunding.entity.CategoryDao;
import com.supinfo.supcrowdfunding.entity.Project;


/**
 * Servlet implementation class ShowCategoryServlet
 */
@WebServlet(urlPatterns = "/showCategory")
public class ShowCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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

		Category category = CategoryDao.findCategoryById(id);
		List<Project> projects = CategoryDao.getCategoryProjects(id);

		if (null == projects) {
			resp.sendRedirect(req.getContextPath() + "/listProject");
			return;
		}

		req.setAttribute("category", category);
		req.setAttribute("projects", projects);
		RequestDispatcher rd = req.getRequestDispatcher("/showCategory.jsp");
		rd.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	}

}
