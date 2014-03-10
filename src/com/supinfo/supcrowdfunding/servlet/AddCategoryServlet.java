package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.Category;
import com.supinfo.supcrowdfunding.entity.CategoryDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/auth/admin/addCategory","/auth/admin/categoriesManagement/addCategory"})
public class AddCategoryServlet extends HttpServlet {
	
	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		//emf = Persistence.createEntityManagerFactory("PU");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		boolean errors = false;
		String url = req.getRequestURL().toString();
		
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		
		RequestDispatcher rd;
		if(name == null || name.trim().isEmpty()) {
			errors = true;
		}
		
		if (errors) {
			req.setAttribute("errors", true);
			if(url.contains("addCategory")){
				rd = req.getRequestDispatcher("/auth/admin/categoriesManagement");
			}else{
				rd = req.getRequestDispatcher("/auth/admin/addCategory.jsp");
			}
		} else {
			Category category = new Category();
			category.setName(name);
			category.setContent(content);
			
			CategoryDao.addCategory(category);
			
			if(url.contains("addCategory")){
				rd = req.getRequestDispatcher("/auth/admin/categoriesManagement");
			}else{				
				rd = req.getRequestDispatcher("/listProject");
			}
		}
		
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = req.getRequestDispatcher("/auth/admin/addCategory.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	public void destroy() {
		emf.close();
	}

}
