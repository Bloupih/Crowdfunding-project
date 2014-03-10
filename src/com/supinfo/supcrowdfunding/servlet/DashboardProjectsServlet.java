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
import com.supinfo.supcrowdfunding.entity.ProjectDao;

/**
 * Servlet implementation class DashboardProjectsServlet
 */
@WebServlet(urlPatterns = "/auth/admin/projectsManagement")
public class DashboardProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardProjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	req.setCharacterEncoding("UTF-8");
    	int totalCountProjects = ProjectDao.getCountProjects();
    	List<Project> projects = ProjectDao.getAllProjects();
    	RequestDispatcher rd = null;

    	List<Category> categories = CategoryDao.getAllCategories();
    	req.setAttribute("categories", categories);
    	req.setAttribute("projects", projects);
    	req.setAttribute("totalCountProjects", totalCountProjects);
    	
    	rd = req.getRequestDispatcher("/auth/admin/dash-projects.jsp");
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
