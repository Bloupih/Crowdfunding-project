package com.supinfo.supcrowdfunding.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcrowdfunding.entity.TransactionDao;

/**
 * Servlet implementation class RemoveTransactionServlet
 */
@WebServlet("/auth/admin/removeTransaction")
public class RemoveTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String idParam = req.getParameter("id");
		RequestDispatcher rd = null;
		int id;

		try {
			id = Integer.valueOf(idParam);
			TransactionDao.removeTransaction(id);
			req.setAttribute("alert", 1);
		} catch (NumberFormatException e) {
			req.setAttribute("alert", 0);
		}	
		rd = req.getRequestDispatcher("/auth/admin/transactionsManagement");
		rd.forward(req, resp);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	}

}
