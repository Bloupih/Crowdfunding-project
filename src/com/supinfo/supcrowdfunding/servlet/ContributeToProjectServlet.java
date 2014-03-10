package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.ProjectDao;

/**
 * Servlet implementation class ContributeToProjectServlet
 */
@WebServlet(urlPatterns = "/auth/contributeToProject")
public class ContributeToProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContributeToProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String idParam = req.getParameter("id");
		String c_price = req.getParameter("contributed_price");
		int idUser = (int) req.getSession().getAttribute("id");
		int id;
		float contributed_price;

		try {
			id = Integer.valueOf(idParam);
			contributed_price = Float.parseFloat(c_price);
			
			ProjectDao.contributeToProject(id, idUser, contributed_price);
			
			resp.sendRedirect(req.getContextPath() + "/showProject?id=" + idParam);
			
			
		} catch (NumberFormatException e) {
			
			resp.sendRedirect(req.getContextPath() + "/showProject?id=" + idParam);
		}
		
		
		
		
		
	}
	

}
