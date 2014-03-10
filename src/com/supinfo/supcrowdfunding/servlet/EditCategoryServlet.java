package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.Category;
import com.supinfo.supcrowdfunding.entity.CategoryDao;

/**
 * Servlet implementation class EditCategoryServlet
 */
@WebServlet(urlPatterns={"/auth/admin/editCategory","/auth/admin/categoriesManagement/editCategory"})
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		if(url.contains("admin")){
			doPost(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		int id = Integer.parseInt(request.getParameter("id"));

		String update_nom = "";
		String update_content = "";
		Category categ ; 
		RequestDispatcher rd ;
		if(request.getParameter("nom") != null && !(request.getParameter("nom").equals("")) )
		{
			update_nom = request.getParameter("nom");
			update_content = request.getParameter("content");
			categ = CategoryDao.findCategoryById(id);
			categ.setName(update_nom);
			categ.setContent(update_content);
			
			CategoryDao.editCategory(categ);
			if(url.contains("admin")){
				rd = request.getRequestDispatcher("/auth/admin/categoriesManagement");
			}else{ rd = request.getRequestDispatcher("/auth/showCategory");}
			
		}
		else
		{
			categ = CategoryDao.findCategoryById(id);
			rd = request.getRequestDispatcher("/auth/admin/editCategory.jsp");
		}
		
		request.setAttribute("category", categ);
		rd.forward(request, response);
	}

}
