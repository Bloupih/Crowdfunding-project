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
import com.supinfo.supcrowdfunding.entity.User;
import com.supinfo.supcrowdfunding.entity.UserDao;

/**
 * Servlet implementation class EditProjectServlet
 */
@WebServlet(urlPatterns = "/auth/admin/editProject")
public class EditProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String idParam = req.getParameter("id");
		RequestDispatcher rd = null;
		int id;
		id = Integer.valueOf(idParam);
		
		List<Category> categories = CategoryDao.getAllCategories();
		List<User> users = UserDao.getAllUsers();
		
		req.setAttribute("users", users);
		req.setAttribute("categories", categories);
		req.setAttribute("project" ,ProjectDao.findProjectById(id));
		rd = req.getRequestDispatcher("/auth/admin/editProject.jsp");
		rd.forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean errors = false;
		
		req.setCharacterEncoding("UTF-8");

		String idparam = req.getParameter("id");
		int idProj = Integer.valueOf(idparam);
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String priceParam = req.getParameter("price");
		String dateStart = req.getParameter("dateStart");
		String dateEnd = req.getParameter("dateEnd");
		
		System.out.println(req.getParameter("name") + " - " + req.getParameter("content"));
		
		int userId = Integer.valueOf(req.getParameter("userID"));
		

		if (name == null || name.trim().isEmpty() || content == null || content.trim().isEmpty()) {
			errors = true;
		}

		float price = 0;

		try {
			price = Float.valueOf(priceParam);
		} catch (NumberFormatException e) {
			errors = true;
		}

		int categoryId = 0;

		try {
			categoryId = Integer.valueOf(req.getParameter("category"));
		} catch (NumberFormatException e) {
			errors = true;
		}

		if (errors) {
			req.setAttribute("errors", true);
			doGet(req,resp);
		} else {
			
			//User user = UserDao.findUserByPseudo(username);
			
			Project project = ProjectDao.findProjectById(idProj);
			project.setName(name);
			project.setContent(content);
			project.setPrice(price);
			project.setDateStart(dateStart);
			project.setDateEnd(dateEnd);
			project.setCreator(userId);
			
			Category category = CategoryDao.findCategoryById(categoryId);
			project.setCategory(category);
			
			ProjectDao.editProject(project);			

			
			resp.sendRedirect(req.getContextPath() + "/auth/admin/projectsManagement");
		}
	}

}
