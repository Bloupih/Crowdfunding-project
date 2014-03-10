package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;
import java.util.List;




/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;*/
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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/auth/addProject")
public class AddProjectServlet extends HttpServlet {

	//private EntityManagerFactory emf;

	@Override
	public void init() throws ServletException {
		//emf = Persistence.createEntityManagerFactory("PU");
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		boolean errors = false;

		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String priceParam = req.getParameter("price");
		String dateStart = req.getParameter("dateStart");
		String dateEnd = req.getParameter("dateEnd");
		String username = (String)req.getSession().getAttribute("username");

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
			
			User user = UserDao.findUserByPseudo(username);
			
			Project project = new Project();
			project.setName(name);
			project.setContent(content);
			project.setPrice(price);
			project.setDateStart(dateStart);
			project.setDateEnd(dateEnd);
			project.setCreator(user.getId());

			Category category = CategoryDao.findCategoryById(categoryId);
			project.setCategory(category);

			ProjectDao.addProject(project);
				
			resp.sendRedirect(req.getContextPath() + "/showProject?id=" + project.getId());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		List<Category> categories = CategoryDao.getAllCategories();
		req.setAttribute("categories", categories);

		RequestDispatcher rd = req.getRequestDispatcher("/auth/addProject.jsp");
		rd.forward(req, resp);
	}

	@Override
	public void destroy() {
	}
}
