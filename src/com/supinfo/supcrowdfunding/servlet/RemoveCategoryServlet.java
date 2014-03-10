package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.CategoryDao;

/**
 * Servlet implementation class RemoveCategoryServlet
 */
@WebServlet(urlPatterns="/auth/admin/removeCategory")
public class RemoveCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCategoryServlet() {
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
			CategoryDao.removeCategory(id);
		} catch (NumberFormatException e) {
		}

		resp.sendRedirect(req.getContextPath() + "/auth/admin/categoriesManagement");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	}
	

}
