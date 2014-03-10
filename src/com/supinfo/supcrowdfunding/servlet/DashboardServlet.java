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
import com.supinfo.supcrowdfunding.entity.Transaction;
import com.supinfo.supcrowdfunding.entity.TransactionDao;
import com.supinfo.supcrowdfunding.entity.UserDao;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet(urlPatterns = "/auth/admin/")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
   }
    
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	req.setCharacterEncoding("UTF-8");
    	int totalCountProjects = ProjectDao.getCountProjects();
    	int totalCountUsers = UserDao.getCountUsers();
    	int totalCountCategories = CategoryDao.getCountCategories();
    	List<Transaction> transactions = TransactionDao.getAllTransactions();
    	List<Category> categories = CategoryDao.getAllCategories();
    	List<Project> projects = ProjectDao.getAllProjects();
    	
    	req.setAttribute("transactions", transactions);
    	req.setAttribute("categories", categories);
    	req.setAttribute("projects", projects);
    	
    	req.setAttribute("totalCountProjects", totalCountProjects);
    	req.setAttribute("totalCountUsers", totalCountUsers);
    	req.setAttribute("totalCountCategories", totalCountCategories);
    	RequestDispatcher rd = req.getRequestDispatcher("/auth/admin/dashboard.jsp");
    	
		rd.forward(req, resp);
    	
    }

}
