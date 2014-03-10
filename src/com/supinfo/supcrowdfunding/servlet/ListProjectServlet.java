package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.Project;
import com.supinfo.supcrowdfunding.entity.ProjectDao;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/listProject", "/Index" })
public class ListProjectServlet extends HttpServlet {

	
	@Override
	public void init() throws ServletException {
	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		List<Project> projects = ProjectDao.getAllProjects();
		RequestDispatcher rd = null;
		req.setAttribute("projects", projects);
		
		if (url.contains("listProject")){
			 rd = req.getRequestDispatcher("/listProject.jsp");
		}else{
			rd = req.getRequestDispatcher("/index.jsp");
			
		}
		rd.forward(req, resp);
    	
    }


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	}

	@Override
	public void destroy() {
		//emf.close();
	}
}
